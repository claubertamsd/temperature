package com.claubert.temperature.responses

import com.claubert.temperature.model.Address
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class GeolocationResponse(
    val display_name:String,
    val lat:String,
    val lon:String,
    @SerialName("address") val addressAndState: Address?
)