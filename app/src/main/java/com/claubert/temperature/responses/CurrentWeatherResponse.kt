package com.claubert.temperature.responses

import kotlinx.serialization.Serializable

@Serializable
data class CurrentWeatherResponse(
    val temperature: Double
)
