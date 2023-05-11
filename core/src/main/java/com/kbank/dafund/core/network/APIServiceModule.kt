package com.kbank.dafund.core.network

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.create
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class APIServiceModule {

    @Provides
    @Singleton
    fun provideUserService(retrofit: Retrofit): UserAPIService = retrofit.create()
}
