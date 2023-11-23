package com.claubert.temperature.components

import androidx.compose.foundation.background
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import com.claubert.temperature.ui.theme.DarkSkies
import com.claubert.temperature.ui.theme.RosesLight

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HeaderBackHome(title:String, onClick: () -> Unit){
    TopAppBar(
        colors = TopAppBarDefaults.smallTopAppBarColors(
            containerColor = Color.Transparent,
            titleContentColor = Color.White,
        ),

     title = {
        Text(
            title,
            textAlign = TextAlign.Center,
            fontWeight = FontWeight.Medium,
            maxLines = 2,
        )
    },
        modifier = Modifier.background(Brush.horizontalGradient(
            colors = listOf(
                DarkSkies,
                RosesLight
            )
        )),
        navigationIcon = {
            IconButton(onClick) {
                Icon(
                    imageVector = Icons.Filled.ArrowBack,
                    tint = Color.White,
                    contentDescription = "Back Home"
                )
            }
        },

    )

}

@Preview
@Composable
fun HeaderBackHomePreview(){
    HeaderBackHome(title = "Selecione uma Cidade", onClick = {})
}