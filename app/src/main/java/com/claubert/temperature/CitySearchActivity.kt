package com.claubert.temperature

import android.annotation.SuppressLint
import android.content.Context
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.claubert.temperature.client.SearchCityClient
import com.claubert.temperature.components.CardCity
import com.claubert.temperature.components.HeaderBackHome
import com.claubert.temperature.components.SearchTextField
import com.claubert.temperature.model.CityViewModel
import com.claubert.temperature.model.Screen

import com.claubert.temperature.ui.theme.DarkSkies
import com.claubert.temperature.ui.theme.GreyLight

import kotlinx.coroutines.launch

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CitySearchScreen(cityViewModel: CityViewModel, navController: NavHostController) {
    val context = LocalContext.current

    var cityText by remember { mutableStateOf(cityViewModel.cityName) }
    var isLoading by remember { mutableStateOf(false) }
    var cityList by remember { mutableStateOf(emptyList<String>()) }
    val coroutineScope = rememberCoroutineScope()

    val updateCityList: (List<String>) -> Unit = { newCityList ->
        cityList = newCityList
        isLoading = false
    }

    Scaffold(
        modifier = Modifier.background(GreyLight),
        topBar = {
            HeaderBackHome(title = "Selecione sua cidade", onClick = {
                navController.navigate(Screen.WeatherPage.route)
            })
        },
        content = {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .background(GreyLight)
                    .padding(top = 80.dp, start = 20.dp, end = 20.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Top
            ) {
                SearchTextField(
                    searchText = cityText,
                    onSearchTextChanged = { newSearchText ->
                        cityText = newSearchText
                    },
                    onSearchSubmit = {
                        isLoading = true
                        coroutineScope.launch {
                            fetchCityData(cityText, context, updateCityList)
                        }
                    },
                    placeholder = "Informe o nome da cidade",
                    modifier = Modifier.padding(horizontal = 10.dp)
                )

                if (isLoading) {
                    CircularProgressIndicator(
                        modifier = Modifier
                            .height(50.dp)
                            .width(50.dp)
                            .padding(top = 20.dp),
                        color = DarkSkies
                    )
                } else {
                    if (cityList.isNotEmpty()) {
                        LazyColumn {
                            items(cityList) { cityInfo ->
                                CardCity(
                                    city = cityInfo,
                                    modifier = Modifier.padding()
                                )
                            }
                        }
                    } else {
                        Text(
                            "Nenhum resultado encontrado.",
                            textAlign = TextAlign.Center,
                            textDecoration = TextDecoration.None
                        )
                    }
                }
            }
        }
    )
}

private suspend fun fetchCityData(
    cityName: String,
    context: Context,
    updateCityList: (List<String>) -> Unit
) {
    val searchCityClient = SearchCityClient()
    val result = searchCityClient.searchCity(cityName, context, isLoading = {

    })
    updateCityList(result)
}

