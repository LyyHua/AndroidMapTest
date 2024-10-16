package com.example.shoppinglistapp

import android.util.Log
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class LocationViewModel : ViewModel() {
    private val _location = mutableStateOf<LocationData?>(null)
    val location: State<LocationData?> = _location

    private val _address = mutableStateOf("")
    val address: State<String> = _address

    private val apiKey = BuildConfig.HERE_API_KEY

    fun updateLocation(newLocation: LocationData) {
        _location.value = newLocation
    }

    fun fetchAddress(lat: Double, lon: Double) {
        try {
            viewModelScope.launch {
                val result = RetrofitClient.create().getAddressFromCoordinates("$lat,$lon", apiKey)
                if (result.items.isNotEmpty()) {
                    _address.value = result.items[0].title
                }
            }
        } catch (e: Exception) {
            Log.d("res1", "${e.cause} ${e.message}")
        }
    }
}