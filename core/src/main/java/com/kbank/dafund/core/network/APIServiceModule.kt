package com.kbank.dafund.core.network

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent
import retrofit2.Retrofit
import retrofit2.create

@Module
@InstallIn(ActivityComponent::class)
class APIServiceModule {

    @Provides
    fun provideUserService(retrofit: Retrofit): UserAPIService = retrofit.create()
}
