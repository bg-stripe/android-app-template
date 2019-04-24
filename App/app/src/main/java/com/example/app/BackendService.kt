package com.app.example

import retrofit2.Call
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST

/**
 * The `BackendService` interface handles the two simple calls we need to make to our backend.
 */
interface BackendService {

    /**
     * POST to an endpoint with a string
     */
    @FormUrlEncoded
    @POST("/my_endpoint")
    fun someMethod(@Field("some_id") id: String): Call<Void>
}

