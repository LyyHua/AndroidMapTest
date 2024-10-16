package com.example.shoppinglistapp

import retrofit2.http.GET
import retrofit2.http.Query

interface GeocodingApiService {

    @GET("v1/revgeocode")
    suspend fun getAddressFromCoordinates(
        @Query("at") at: String,
        @Query("apiKey") apiKey: String
    ): GeocodingResponse
}