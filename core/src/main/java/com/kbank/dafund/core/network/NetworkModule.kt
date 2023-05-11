package com.kbank.dafund.core.network

import android.app.Application
import android.content.Context
import com.chuckerteam.chucker.api.ChuckerInterceptor
import com.facebook.stetho.okhttp3.StethoInterceptor
import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlinx.serialization.json.Json
import okhttp3.Cache
import okhttp3.Interceptor
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class NetworkModule {

    @Provides
    @Singleton
    fun provideOkHttpCache(application: Application): Cache =
        Cache(application.cacheDir, 10L * 1024L * 1024L)

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
        cache: Cache
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
        }
        return builder.build()
    }

    @Provides
    @Singleton
    fun provideRetrofit(okHttpClient: OkHttpClient): Retrofit {
        val contentType = "application/json".toMediaType()
        return Retrofit.Builder()
            .addConverterFactory(Json.asConverterFactory(contentType))
            .baseUrl("BASE_URL") // TODO: add BASE_URL
            .client(okHttpClient)
            .build()
    }
}
