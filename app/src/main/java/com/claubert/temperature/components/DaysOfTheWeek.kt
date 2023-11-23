package com.claubert.temperature.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.claubert.temperature.R
import com.claubert.temperature.ui.theme.PurpleA700

@Composable
fun DaysOfTheWeek(day: String, imageRes: Int, temp: String ){
    Column (
        modifier = Modifier.padding(10.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            day,
            modifier = Modifier.padding(top = 6.dp),
            fontSize = 20.sp,
            fontWeight = FontWeight.Medium,
            color = PurpleA700
        )
        Image(
            painter = painterResource(id = imageRes),
            contentDescription = null,
            modifier = Modifier
                .padding(top = 6.dp)
                .height(50.dp)
                .width(50.dp)

        )
        Text(
            "${temp}°C",
            modifier = Modifier.padding(top = 10.dp),
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold,
            color = PurpleA700

        )
    }
}

@Preview
@Composable
fun DaysOfTheWeekPreview(){
  DaysOfTheWeek(day = "TER", imageRes = R.drawable.storm, temp = "33")
}