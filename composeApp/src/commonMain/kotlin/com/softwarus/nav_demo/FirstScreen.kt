package com.softwarus.nav_demo

import androidx.compose.foundation.layout.Column
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue

@Composable
fun FirstScreen(onNavigateToSecondScreen : (CustomClass) -> Unit ){

    Column {
        var txtVal by rememberSaveable { mutableStateOf("") }
        TextField(
            value = txtVal,
            onValueChange = {
                txtVal = it
            }
        )
        Button(
            onClick = {
                onNavigateToSecondScreen(CustomClass(txtVal))
            },
            content = {
                Text("Navigate to Second Screen")
            }
        )
    }

}