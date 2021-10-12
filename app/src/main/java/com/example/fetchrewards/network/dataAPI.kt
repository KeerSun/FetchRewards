package com.example.fetchrewards.network

import retrofit2.http.GET

interface dataAPI {
    @GET("hiring.json")
    suspend fun getPosts(): List<dataModel>
}