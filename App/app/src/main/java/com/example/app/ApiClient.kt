package com.app.example

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
// Uncomment after installing the Terminal SDK
//import com.stripe.stripeterminal.ConnectionTokenException
import java.io.IOException

/**
 * The `ApiClient` is a singleton object used to make calls to our backend and return their results
 * This class is ready to use with the Terminal SDK and example-terminal-backend after enabling the commented out lines.
 */
object ApiClient {

    /**
     * To get started with this demo, you'll need to first deploy an instance of
     * our provided example backend:
     *
     * https://github.com/stripe/example-terminal-backend
     *
     * After deploying your backend, replace "" on the line below with the URL of your Heroku app.
     *
     * private const val BACKEND_URL = "https://your-app.herokuapp.com"
     */
    private const val BACKEND_URL = ""

    private val client = OkHttpClient()
    private val retrofit : Retrofit = Retrofit.Builder()
        .baseUrl(BACKEND_URL)
        .client(client)
        .addConverterFactory(GsonConverterFactory.create())
        .build()
    private val service : BackendService = retrofit.create(BackendService::class.java)

    // Uncomment after installing the Terminal SDK
    /**
    @Throws(ConnectionTokenException::class)
    internal fun createConnectionToken(): String {
        val result = service.getConnectionToken().execute()
        if (result.isSuccessful && result.body() != null) {
            return result.body()!!.secret
        }

        throw ConnectionTokenException("Creating connection token failed")
    }

    internal fun capturePaymentIntent(id: String) {
        service.capturePaymentIntent(id).execute()
    }
    */
}
