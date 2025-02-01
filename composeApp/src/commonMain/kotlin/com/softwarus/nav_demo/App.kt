package com.softwarus.nav_demo

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.asPaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.systemBars
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.toRoute
import org.jetbrains.compose.ui.tooling.preview.Preview
import kotlin.reflect.typeOf

@Composable
@Preview
fun App() {
    MaterialTheme(
    ) {
        val navigator = rememberNavController()

        Box(modifier = Modifier.fillMaxSize()
            .padding(WindowInsets.systemBars.asPaddingValues())) {
            NavHost(navigator, startDestination = First) {
                composable<First> {
                    FirstScreen (onNavigateToSecondScreen = { value ->
                        navigator.navigate(Second(value))
                    })
                }
                composable<Second>(
                    typeMap = mapOf(typeOf<CustomClass>() to CustomNavTypes.customClassType)
                ) { backStackEntry ->
                    val strValue = backStackEntry.toRoute<Second>().objValue
                    SecondScreen(strValue)
                }
            }
        }
    }
}