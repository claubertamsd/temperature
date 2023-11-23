package com.claubert.temperature.model

sealed class Screen (val route: String) {
        object WeatherPage : Screen("weatherPage")
        object CitySearchScreen : Screen("citySearchScreen")

}