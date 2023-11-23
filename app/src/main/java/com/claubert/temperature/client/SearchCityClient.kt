package com.claubert.temperature.client

import android.content.Context
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class SearchCityClient {
    private val retrofit = Retrofit.Builder()
        .baseUrl("https://nominatim.openstreetmap.org/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    private val nominatimService = retrofit.create(NominatimService::class.java)

    suspend fun searchCity(
        cityName: String,
        context: Context,
        isLoading: () -> Unit
    ): List<String> {
        val cityInfoList = mutableListOf<String>()
        try {
            val response = nominatimService.searchCity(cityName)
            response.forEach { cityData ->
                val city = cityData.addressAndState?.city
                val state = cityData.addressAndState?.state
                val cityAndState = "$city, $state"
                cityInfoList.add(cityAndState)
            }
        } catch (e: Exception) {

        } finally {
            isLoading()
        }
        return cityInfoList
    }
}


