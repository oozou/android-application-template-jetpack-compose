package com.kbank.dafund.domain.user.repository

import com.kbank.dafund.core.network.UserApiService
import com.kbank.dafund.core.network.tryApiCall
import javax.inject.Inject

class UserRepository @Inject constructor(private val userService: UserApiService) {

    suspend fun getUser(): List<String> {
        return tryApiCall {
            userService.getUser()
        }
    }
}
