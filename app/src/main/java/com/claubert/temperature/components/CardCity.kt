package com.claubert.temperature.components




import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Done
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.claubert.temperature.R


@Composable
fun CardCity(city: String, modifier: Modifier) {
    Card(
        modifier = modifier
            .fillMaxWidth()
            .heightIn(90.dp, 110.dp)
            .padding(top = 15.dp)

    ) {
                    Row(
                        modifier
                            .fillMaxSize()
                            .background(Color.White),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.SpaceAround,

                    ) {

                        Row (
                            horizontalArrangement = Arrangement.Center,
                            verticalAlignment = Alignment.CenterVertically,
                        ){
                            Icon(
                                painter = painterResource(id = R.drawable.location),
                                contentDescription = null,
                                modifier.padding(end = 6.dp)

                                )

                            Text(
                                text = city,
                                fontSize = 22.sp,
                                maxLines = 1
                                )
                        }


                        IconButton(
                            onClick = { /* Handle button click */ },

                        ) {
                            Icon(
                                imageVector = Icons.Default.Done,
                                contentDescription = null,
                                modifier = Modifier.size(35.dp)
                            )
                        }
                    }
                }


}



@Preview
@Composable
fun CardCityPreview() {
    CardCity(city = "Petrolina, PE",  modifier = Modifier.padding())
}