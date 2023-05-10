package com.kbank.dafund.core.pref

import android.content.Context
import androidx.datastore.dataStore
import com.kbank.dafund.domain.user.models.UserSettings
import kotlinx.coroutines.flow.first

class UserSettingsDataStore constructor(private val context: Context) {

    private val Context.dataStore by dataStore(
        fileName = SETTINGS_DATASTORE,
        serializer = UserSettingsSerializer(CryptoManager())
    )

    suspend fun update(userSettings: UserSettings) {
        context.dataStore.updateData {
            userSettings
        }
    }

    suspend fun get(): UserSettings? {
        return context.dataStore.data.first()
    }

    companion object {
        const val SETTINGS_DATASTORE = "user_settings.json"
    }
}
