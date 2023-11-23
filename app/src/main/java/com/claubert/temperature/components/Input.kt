package com.claubert.temperature.components


import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.runtime.Composable

import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Clear
import androidx.compose.material.icons.filled.Search

import androidx.compose.material3.Card
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf

import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight

import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import com.claubert.temperature.ui.theme.PurpleA700
import com.claubert.temperature.ui.theme.ShappeInput


@Composable
fun SearchTextField(
    searchText: String,
    onSearchTextChanged: (String) -> Unit,
    onSearchSubmit: () -> Unit,
    placeholder: String,
    modifier: Modifier
) {
    var isSearching by remember { mutableStateOf(false) }
    Column(modifier = modifier.fillMaxWidth().padding(bottom = 10.dp)) {
        Card(
            shape = ShappeInput.large,
            modifier = Modifier.fillMaxWidth().height(80.dp),
        ) {
            Row(
                modifier = Modifier.fillMaxWidth().background(Color.White).height(80.dp),
                verticalAlignment = Alignment.CenterVertically,
            ) {
                BasicTextField(
                    value = searchText,
                    onValueChange = { newText ->
                        onSearchTextChanged(newText)
                        isSearching = newText.isNotEmpty()
                    },
                    keyboardOptions = KeyboardOptions.Default.copy(imeAction = ImeAction.Search),
                    keyboardActions = KeyboardActions(onSearch = { onSearchSubmit() }),
                    decorationBox = { innerTextField ->
                        Box(
                            modifier = Modifier
                                .fillMaxWidth(),
                            contentAlignment = Alignment.CenterStart

                        ) {
                            if (searchText.isEmpty()) {
                                Text(
                                    text = placeholder,
                                    fontSize = 20.sp,
                                    fontWeight = FontWeight.Normal,
                                    color = Color.LightGray
                                )
                            }
                            innerTextField()
                        }
                    },
                    modifier = Modifier
                        .weight(1f)
                        .padding(14.dp)
                        .background(Color.White)
                        .border(1.dp, Color.Transparent)
                )
                if (isSearching) {
                    IconButton(
                        onClick = {
                            onSearchTextChanged("")
                            isSearching = false
                        },
                        modifier = Modifier.padding(4.dp)
                    ) {
                        Icon(
                            imageVector = Icons.Default.Clear,
                            contentDescription = "Clear Search",
                            tint = Color.Gray
                        )
                    }
                }
                IconButton(
                    onClick = { onSearchSubmit() },
                    modifier = Modifier.padding(3.dp)
                ) {
                    Icon(
                        imageVector = Icons.Default.Search,
                        contentDescription = "Search",
                        tint = PurpleA700,
                        modifier = Modifier.height(40.dp).width(40.dp)
                    )
                }
            }
        }
    }
}


@Preview
@Composable
fun SearchTextFieldPreview(){
    SearchTextField(searchText = "", onSearchTextChanged ={}, onSearchSubmit = {},"Informe o nome da cidade", modifier = Modifier.padding() )
}

