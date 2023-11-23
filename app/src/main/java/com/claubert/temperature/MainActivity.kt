package com.claubert.temperature


import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.claubert.temperature.model.CityViewModel
import com.claubert.temperature.model.Screen

class MainActivity : ComponentActivity() {

    private val cityViewModel: CityViewModel by viewModels()
    @SuppressLint("CoroutineCreationDuringComposition")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            val navController = rememberNavController()
            NavHost(navController, startDestination = Screen.WeatherPage.route) {
                composable(Screen.WeatherPage.route) {
                    WeatherPage(navController)
                }
                composable(Screen.CitySearchScreen.route) {
                    CitySearchScreen(cityViewModel,navController)
                }
            }
        }

   }

}




