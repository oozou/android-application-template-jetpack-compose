package com.kbank.dafund.domain.user.repository

import android.content.SharedPreferences
import com.kbank.dafund.core.network.UserApiService
import com.kbank.dafund.core.network.tryApiCall
import javax.inject.Inject

class UserRepository @Inject constructor(
    private val userService: UserApiService,
    private val sharedPreference: SharedPreferences
) {

    suspend fun getUser(): List<String> {
        return tryApiCall {
            userService.getUser()
        }
    }

    fun saveSampleData(value: String?) {
        sharedPreference.edit().apply {
            putString("testKey", value)
            apply()
        }
    }

    fun getSampleData(): String? {
        return sharedPreference.getString("testKey", null)
    }
}
