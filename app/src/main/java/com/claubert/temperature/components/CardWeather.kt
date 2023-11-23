package com.claubert.temperature.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import com.claubert.temperature.R
import com.claubert.temperature.ui.theme.DarkSkies

import com.claubert.temperature.ui.theme.RosesLight
import com.claubert.temperature.ui.theme.ShappeButton

@Composable
fun CardWeather(city: String, day: String, temp: String){

    Card (
        modifier = Modifier
            .height(400.dp)
            .fillMaxWidth()
            .padding(20.dp)
            .background(
               Color.Transparent
            ),
        shape = ShappeButton.large,

       elevation = CardDefaults.cardElevation(
           defaultElevation = 6.dp
       ),


    ){
        ConstraintLayout (
            modifier = Modifier.fillMaxWidth().fillMaxHeight().background( brush = Brush.horizontalGradient(
                colors = listOf(
                    DarkSkies,
                    RosesLight
                )
            ))
        ) {

            val (cityName, dayOfWeek, tempOfDay, imgTemp,) = createRefs()

            Text(
                text = city,
                textAlign = TextAlign.Center,
                color = Color.White,
                fontSize = 18.sp,
                fontStyle = FontStyle.Normal,
                modifier = Modifier.constrainAs(cityName) {
                    top.linkTo(parent.top, margin = 20.dp)
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                }
            )

            Text(
                text = day,
                textAlign = TextAlign.Center,
                color = Color.White,
                fontSize = 30.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.constrainAs(dayOfWeek) {
                    top.linkTo(cityName.bottom, margin = 10.dp)
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                }
            )

            Image(
                painter = painterResource(id = R.drawable.cloud),
                contentDescription = null,
                modifier = Modifier
                    .height(120.dp)
                    .width(120.dp)
                    .padding(top = 16.dp)
                    .constrainAs(imgTemp) {
                        top.linkTo(dayOfWeek.bottom)
                        start.linkTo(parent.start)
                        end.linkTo(parent.end)
                    }
            )

            Text(
                text = "${temp}°C",
                fontSize = 80.sp,
                fontWeight = FontWeight.Bold,
                color = Color.White,
                modifier = Modifier.constrainAs(tempOfDay) {
                    top.linkTo(imgTemp.bottom)
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                }
            )

        }

    }
}

@Preview
@Composable
fun CardWeatherPreview(){
    CardWeather("Petrolina, PE", "Segunda-Feira", "37")
}