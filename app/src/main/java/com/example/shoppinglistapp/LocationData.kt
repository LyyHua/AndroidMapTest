package com.example.shoppinglistapp

data class LocationData(
    val latitude: Double,
    val longitude: Double
)

data class GeocodingResponse(
    val items: List<GeocodingResult>
)

data class GeocodingResult(
    val title: String
)