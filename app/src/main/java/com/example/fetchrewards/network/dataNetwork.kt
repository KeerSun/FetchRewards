package com.example.fetchrewards.network

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object dataNetwork {
    val retrofit by lazy {
        Retrofit.Builder()
            .baseUrl("https://fetch-hiring.s3.amazonaws.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(dataAPI::class.java)
    }
}