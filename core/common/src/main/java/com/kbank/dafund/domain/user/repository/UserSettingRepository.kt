package com.kbank.dafund.domain.user.repository

import com.kbank.dafund.core.pref.UserSettingsDataStore
import com.kbank.dafund.domain.user.models.UserSettings
import javax.inject.Inject

class UserSettingRepository @Inject constructor(private val userSettingsDataStore: UserSettingsDataStore) {

    suspend fun getUserSettings(): UserSettings? {
        return userSettingsDataStore.get()
    }

    suspend fun updateUserSettings(userSettings: UserSettings) {
        userSettingsDataStore.update(userSettings)
    }
}
