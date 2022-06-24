package com.weathercompose.ui

import android.content.Context
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.weathercompose.R
import com.weathercompose.ui.screens.ForecastScreen
import com.weathercompose.ui.screens.MainScreen
import com.weathercompose.ui.theme.WeatherComposeTheme

class MainActivity : ComponentActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            WeatherComposeTheme() {
                MyProject(this)
            }
        }


    }
}
/*
private fun permissionListener() {
    val pLauncher: ActivityResultLauncher<String>
    pLauncher = registerForActivityResult(
        ActivityResultContracts.RequestPermission()
    ) {
        //Toast.makeText(context, "Permission is $it", Toast.LENGTH_SHORT).show()
    }

}

private fun checkPermission() {
    if (!isPermissionGranted(Manifest.permission.ACCESS_FINE_LOCATION)) {
        permissionListener()
        pLauncher.launch(Manifest.permission.ACCESS_FINE_LOCATION)
    }
}

fun isPermissionGranted(p: String): Boolean {
    return ContextCompat.checkSelfPermission(ComponentActivity,
         p) == PackageManager.PERMISSION_GRANTED
}*/


@Composable
fun MyProject(context: Context) {
    WeatherComposeTheme {
        Image(
            painter = painterResource(id = R.drawable.ic_back_new),
            contentDescription = "imageBack",
            modifier = Modifier
                .fillMaxSize()
                .alpha(0.5f),
            contentScale = ContentScale.FillBounds
        )
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(top = 4.dp, start = 4.dp, end = 4.dp)
        ) {
            MainScreen("Dubai", context)
            //ForecastScreen("Any")
            Scroll()
        }
    }
}

@Composable
fun Scroll(names: List<String> = List(100) { "Any date" }) {
    LazyColumn {
        items(names) { name ->
            ForecastScreen(name)

        }
    }

}



