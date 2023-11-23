package com.claubert.temperature.client

import com.claubert.temperature.responses.GeolocationResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface NominatimService {
    @GET("search")
    suspend fun searchCity(
        @Query("q") cityName: String,
        @Query("format") format: String = "json"
    ): List<GeolocationResponse>
}
