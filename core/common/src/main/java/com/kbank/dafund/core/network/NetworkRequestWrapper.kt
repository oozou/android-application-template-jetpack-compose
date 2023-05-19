package com.kbank.dafund.core.network

import retrofit2.HttpException
import java.lang.Exception
import java.net.SocketTimeoutException
import java.net.UnknownHostException

suspend fun <T> tryApiCall(apiCall: suspend () -> T): T {
    return try {
        apiCall()
    } catch (throwable: Throwable) {
        when (throwable) {
            is SocketTimeoutException -> throw NoNetworkException(throwable.message)
            is UnknownHostException -> throw ServerUnreachableException(throwable.message)
            is HttpException -> throw resolveHttpException(throwable)
            else -> throw Exception(throwable.message)
        }
    }
}

fun resolveHttpException(exception: HttpException): Exception {
    return when (exception.code()) {
        401 -> AuthorizationException(exception.message())
        else -> InternalServerException(exception.message())
    }
}
