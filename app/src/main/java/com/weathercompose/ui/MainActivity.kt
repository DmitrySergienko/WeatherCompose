package com.weathercompose.ui

import android.content.Context
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.android.volley.Request
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.google.gson.Gson
import com.weathercompose.R
import com.weathercompose.data.models.ForecastResponse
import com.weathercompose.ui.screens.ForecastScreen
import com.weathercompose.ui.screens.MainScreen
import com.weathercompose.ui.screens.MyBottomNavigationScreen
import com.weathercompose.ui.theme.WeatherComposeTheme
import org.json.JSONObject


private const val API_KEY = "886e042c31bc49c3a3f131017220902"

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

            MainScreen(context)
            MyBottomNavigationScreen()
            Spacer(modifier = Modifier.height(8.dp))
            Scroll(context)
        }
    }
}

@Composable

fun Scroll(context: Context, names: List<String> = List(100) { "Any date" }) {

    val forecastState = rememberSaveable() { mutableStateOf("No data") }
    getWeatherByHour("London", context, forecastState)

    LazyColumn(
        contentPadding = PaddingValues(bottom = 30.dp)
    ) {

        items(getWeatherByHour()) { name ->

            ForecastScreen(name)

        }
    }




}
fun getWeatherByHour(name: String, context: Context, forecastState: MutableState<String>) {


    val url = "http://api.weatherapi.com/v1/forecast.json" +
            "?key=$API_KEY&" +
            "q=$name" +
            "days=3" +
            "&aqi=no" +
            "&alerts=no"

    val queue = Volley.newRequestQueue(context)
    val stringRequest = StringRequest(
        Request.Method.GET,
        url,
        { response ->
            val forecastRes: ForecastResponse = Gson().fromJson(response, ForecastResponse::class.java)
            Log.d("forecastRes",forecastRes.toString())
            //forecastRes.forecast?.forecastday?.get(0)?.date?
            val date = forecastRes.forecast?.forecastday?.get(0)?.hour.toString()
            forecastState.value = listOf(date)

        },
        {
            Log.d("MyLog", "Volley error: $it")
        }
    )
    queue.add(stringRequest)
}









