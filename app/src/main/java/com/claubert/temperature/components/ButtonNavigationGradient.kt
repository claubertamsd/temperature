package com.claubert.temperature.components

import androidx.compose.foundation.background

import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.claubert.temperature.ui.theme.DarkSkies
import com.claubert.temperature.ui.theme.RosesLight
import com.claubert.temperature.ui.theme.ShappeButton

@Composable
fun ButtonNavigationGradient(textButton: String,onClick: () -> Unit) {
    Button(
        onClick,
        modifier = Modifier
            .padding(top = 16.dp)
            .height(60.dp)
            .width(200.dp)
            .background(
                Brush.horizontalGradient(
                    colors = listOf(
                        DarkSkies,
                        RosesLight

                    )
                ),
                shape = ShappeButton.large
            ),

        colors = ButtonDefaults.buttonColors(
            containerColor = Color.Transparent
        ),
        
        ) {
        Text(text = textButton,
            fontSize = 18.sp
            )
    }
}

@Preview
@Composable
fun buttonNavigationGradientPreview(){
   ButtonNavigationGradient(textButton = "Mudar Cidade") {

   }
}