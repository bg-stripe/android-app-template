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
     * Get a ConnectionToken secret from the backend
     */
    @POST("/connection_token")
    fun getConnectionToken(): Call<ConnectionToken>

    /**
     * Capture a PaymentIntent on our backend
     */
    @FormUrlEncoded
    @POST("/capture_payment_intent")
    fun capturePaymentIntent(@Field("payment_intent_id") id: String): Call<Void>
}

/**
 * A one-field data class used to handle the ConnectionToken response from our backend
 */
data class ConnectionToken(val secret: String)