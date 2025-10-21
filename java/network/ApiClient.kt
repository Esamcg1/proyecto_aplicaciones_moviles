package network

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ApiClient {
    private val retrofit = Retrofit.Builder()
        .baseUrl("http://localhost:4200/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    val service: ApiService = network.ApiClient.retrofit.create(ApiService::class.java)
}