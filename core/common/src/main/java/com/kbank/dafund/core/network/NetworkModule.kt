package com.kbank.dafund.core.network

import android.app.Application
import android.content.Context
import com.chuckerteam.chucker.api.ChuckerInterceptor
import com.facebook.stetho.okhttp3.StethoInterceptor
import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import com.kbank.dafund.Secrets
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlinx.serialization.json.Json
import okhttp3.Cache
import okhttp3.CertificatePinner
import okhttp3.Interceptor
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import java.net.URI
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

// TODO: IT Security requirement 6.18 The mobile application must either uses its own certificate store, or pins the endpoint certificate or public key, and subsequently does not establish connections with endpoints that offer a different certificate or key, even if they are signed by a trusted CA, to prevent data modification during transmission (man-in-the-middle attack).
@Module
@InstallIn(SingletonComponent::class)
class NetworkModule {

    @Provides
    @Singleton
    fun provideOkHttpCache(application: Application): Cache =
        Cache(application.cacheDir, 10L * 1024L * 1024L)

    @Provides
    @Singleton
    fun makeCertificatePinner(context: Context, secrets: Secrets): CertificatePinner {
        val packageName = context.packageName
        val publicKey = secrets.getApiTLSPublicKeys(packageName)
        val uri = URI(secrets.getBaseAPIUrl1(packageName)) // this url will be applied ssl pinning
        return CertificatePinner.Builder().apply {
            add(uri.host, publicKey)
        }.build()
    }

    @Provides
    internal fun provideHttpLoggingInterceptor(): HttpLoggingInterceptor {
        val logging = HttpLoggingInterceptor()
        logging.level = if (true) { // TODO: Add is debuggable logic
            HttpLoggingInterceptor.Level.BODY
        } else {
            HttpLoggingInterceptor.Level.NONE
        }
        return logging
    }

    @Provides
    internal fun providesOkhttpInterceptor(): Interceptor {
        return Interceptor { chain: Interceptor.Chain ->
            val requestBuilder: Request.Builder
            val original: Request = chain.request()
            if (true) { // TODO: add is signed in logic
                requestBuilder = original.newBuilder()
            } else {
                // TODO: add header interception
//                val language = getCurrentLanguageUseCase().language
                requestBuilder = original.newBuilder()
//                    .addHeader("Authorization", "Bearer ${getRefreshTokenUseCase()}")
//                    .addHeader("Accept-Language", language)
            }
            val request: Request = requestBuilder.build()
            chain.proceed(request)
        }
    }

    @Provides
    @Singleton
    fun provideOkHttpClient(
        context: Context,
        logging: HttpLoggingInterceptor,
        interceptor: Interceptor,
        cache: Cache,
        certificatePinner: CertificatePinner?
    ): OkHttpClient {
        val builder = OkHttpClient.Builder()
            .addInterceptor(logging)
            .addInterceptor(interceptor)
            .cache(cache)
            .connectTimeout(30, TimeUnit.SECONDS)
            .readTimeout(30, TimeUnit.SECONDS)
            .writeTimeout(30, TimeUnit.SECONDS)
        if (true) { // TODO: Add is debuggable logic
            builder.addInterceptor(ChuckerInterceptor.Builder(context).build())
            builder.addNetworkInterceptor(StethoInterceptor())
        } else {
            // apply certificate pinning only for non-debuggable app, just in case we might need to a mock server
            certificatePinner?.let {
                builder.certificatePinner(certificatePinner)
            }
        }
        return builder.build()
    }

    @Provides
    @Singleton
    fun provideRetrofit(context: Context, okHttpClient: OkHttpClient, secrets: Secrets): Retrofit {
        val contentType = "application/json".toMediaType()
        val packageName = context.packageName
        return Retrofit.Builder()
            .addConverterFactory(Json.asConverterFactory(contentType))
            .baseUrl(secrets.getBaseAPIUrl1(packageName)) // TODO: add BASE_URL
            .client(okHttpClient)
            .build()
    }
}
