package com.softwarus.nav_demo

import androidx.compose.foundation.layout.Column
import androidx.compose.material.Text
import androidx.compose.runtime.Composable

@Composable
fun SecondScreen(passedVal:CustomClass){

    Column {
        Text(
            text = "Second Screen"
        )
        Text(
            text = "Passed Value: ${passedVal.content}"
        )
    }
}
