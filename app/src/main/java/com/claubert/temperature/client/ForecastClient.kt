package com.claubert.temperature.client

import com.claubert.temperature.responses.ForecastResponse
import io.ktor.client.call.body
import io.ktor.client.request.get

class ForecastClient {
    suspend fun getCurrentWeather() : ForecastResponse {
        return KtorClient.httpClient.get(
            "https://api.open-meteo.com/v1/forecast?latitude=-9.353674&longitude=-40.4765804&current_weather=true"
        ).body()
    }

}