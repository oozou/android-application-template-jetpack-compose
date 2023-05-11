package com.kbank.dafund.core.network

import java.lang.Exception

class ServerUnreachableException(message: String?) : Exception(message)
class NoNetworkException(message: String?) : Exception(message)
class AuthorizationException(message: String?) : Exception(message)
class InternalServerException(message: String?) : Exception(message)
