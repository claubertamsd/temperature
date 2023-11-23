package com.claubert.temperature.model


import kotlinx.serialization.Serializable

@Serializable
data class Address(
   val city : String,
   val state: String
)
