package com.kbank.dafund.core.network

import retrofit2.http.GET
import retrofit2.http.Path

// TODO: TBC
interface UserApiService {

    @GET("v1/xxxx")
    suspend fun getUser(): List<String>

    @GET("v1/xxxx")
    suspend fun getXXXX(@Path("provinceId") provinceId: Int): List<String>
}
