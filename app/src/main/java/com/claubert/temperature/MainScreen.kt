package com.claubert.temperature

import android.annotation.SuppressLint
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.claubert.temperature.client.ForecastClient
import com.claubert.temperature.client.GeolocationClient
import com.claubert.temperature.components.ButtonNavigationGradient
import com.claubert.temperature.components.CardWeather
import com.claubert.temperature.components.DaysOfTheWeek
import com.claubert.temperature.model.Screen
import com.claubert.temperature.responses.ForecastResponse
import com.claubert.temperature.responses.GeolocationResponse
import kotlinx.coroutines.runBlocking
import java.text.DecimalFormat

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun WeatherPage(
    navController: NavHostController
) {
    val forecastClient = ForecastClient()
    var forecastResponse: ForecastResponse

    val geolocationClient = GeolocationClient()
    var geolocationResponse: GeolocationResponse
    val decimalFormat = DecimalFormat("#")


    runBlocking {
        forecastResponse = forecastClient.getCurrentWeather()
        geolocationResponse = geolocationClient.getLocation(forecastResponse.latitude,forecastResponse.longitude)

    }
    val formattedTemperature =
        decimalFormat.format(forecastResponse.currentWeather.temperature)
    Scaffold {
        Column (horizontalAlignment = Alignment.CenterHorizontally){

            geolocationResponse.addressAndState?.let { it1 ->
                CardWeather(
                    it1.city,"Quarta-Feira", formattedTemperature,
                )
            }

            Row (
                modifier = Modifier
                    .horizontalScroll(rememberScrollState())
                    .padding(20.dp)
            ){
                DaysOfTheWeek(day = "TER", imageRes = R.drawable.cloud, temp = "38")
                DaysOfTheWeek(day = "QUA", imageRes = R.drawable.storm, temp = "12")
                DaysOfTheWeek(day = "QUI", imageRes = R.drawable.weather, temp = "23")
                DaysOfTheWeek(day = "SEX", imageRes = R.drawable.rainy, temp = "25")
                DaysOfTheWeek(day = "SAB", imageRes = R.drawable.snow, temp = "13")
                DaysOfTheWeek(day = "DOM", imageRes = R.drawable.cloud, temp = "15")
            }

            ButtonNavigationGradient(textButton = "Mudar Cidade") {
                    navController.navigate(Screen.CitySearchScreen.route)
                }
            }



    }

}




