package com.claubert.temperature.client


import com.claubert.temperature.responses.GeolocationResponse
import io.ktor.client.call.body
import io.ktor.client.request.get

class GeolocationClient() {
    suspend fun getLocation(latitude:Double, longitude: Double) : GeolocationResponse{
        return KtorClient.httpClient.get(
            "https://nominatim.openstreetmap.org/reverse?lat=${latitude}&lon=${longitude}&format=json"
        ).body()
    }
}