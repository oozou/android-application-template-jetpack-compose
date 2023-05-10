package com.kbank.dafund.domain.user.repository

import com.kbank.dafund.core.network.UserAPIService
import com.kbank.dafund.core.network.tryApiCall
import javax.inject.Inject

class UserRepository @Inject constructor(private val userService: UserAPIService) {

    suspend fun getUser(): List<String> {
        return tryApiCall {
            userService.getUser()
        }
    }
}
