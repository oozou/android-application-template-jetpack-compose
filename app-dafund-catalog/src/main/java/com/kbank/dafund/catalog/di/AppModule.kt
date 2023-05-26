package com.kbank.dafund.catalog.di

import android.app.Application
import android.content.Context
import android.content.SharedPreferences
import com.kbank.dafund.Secrets
import com.kbank.dafund.core.db.DafundDatabase
import com.kbank.dafund.core.db.DafundDatabaseDao
import com.kbank.dafund.core.pref.SecretSharedPreference
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class AppModule {

    @Provides
    fun provideContext(application: Application): Context = application.applicationContext

    @Provides
    @Singleton
    fun provideSecrets(): Secrets = Secrets()

    @Provides
    @Singleton
    fun provideSecretSharedPreference(context: Context): SharedPreferences =
        SecretSharedPreference(context).getInstance()

    // ref https://stackoverflow.com/a/63146319/2318558
    @Singleton
    @Provides
    fun provideDatabase(context: Context, sharedPreferences: SharedPreferences): DafundDatabase =
        DafundDatabase.createDB(context, sharedPreferences)

    @Singleton
    @Provides
    fun provideSecureRoomDatabaseDao(db: DafundDatabase): DafundDatabaseDao = db.databaseDao
}
