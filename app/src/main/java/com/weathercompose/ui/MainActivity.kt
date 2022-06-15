package com.weathercompose.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.weathercompose.ui.screens.MainScreen
import com.weathercompose.ui.theme.WeatherComposeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            WeatherComposeTheme {
                MainScreen("London",this)
            }
        }
    }
}
