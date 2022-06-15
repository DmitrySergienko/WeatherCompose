package com.weathercompose.ui.screens


import android.content.Context
import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.android.volley.Request
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.weathercompose.R
import com.weathercompose.ui.theme.BlueLight
import com.weathercompose.ui.theme.WeatherComposeTheme
import org.json.JSONObject

private const val API_KEY = "886e042c31bc49c3a3f131017220902"


@Composable
fun MainScreen(cityName: String, context: Context) {

    val stateTemp = remember { mutableStateOf("Undefined") }
    val stateDate = remember { mutableStateOf("Undefined") }


    // getTemperature("London")
    getTemperature(cityName, context, stateTemp)
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(2.dp)
    ) {
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .alpha(0.9f)
                .padding(bottom = 5.dp),
            backgroundColor = BlueLight,
            elevation = 0.dp,
            shape = RoundedCornerShape(10.dp)
        ) {
            Column(
                modifier = Modifier.fillMaxWidth(),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {

                    Text(
                        modifier = Modifier
                            .padding(1.dp)
                            .clickable { getConditions(cityName, context, stateDate) },
                        text = "${stateDate.value}",
                        style = TextStyle(fontSize = 18.sp),
                        color = Color.White
                    )


                    AsyncImage(
                        model = "https://cdn.weatherapi.com/weather/64x64/day/113.png",
                        contentDescription = "imageIcon",
                        modifier = Modifier
                            .size(100.dp)
                            .padding(top = 2.dp, end = 2.dp)
                    )

                }
                Text(
                    modifier = Modifier.padding(15.dp),
                    text = "$cityName",
                    style = TextStyle(fontSize = 25.sp),
                    color = Color.White
                )

                Text(
                    modifier = Modifier
                        .padding(top = 5.dp),

                    text = "${stateTemp.value} C",
                    style = TextStyle(fontSize = 65.sp),
                    color = Color.White
                )
                Text(
                    modifier = Modifier.padding(1.dp),
                    text = "Sunny",
                    style = TextStyle(fontSize = 15.sp),
                    color = Color.White
                )
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.ic_baseline_search_24),
                        contentDescription = "icon_search",
                        modifier = Modifier
                            .padding(10.dp)

                    )
                    Image(
                        painter = painterResource(id = R.drawable.ic_baseline_autorenew_24),
                        contentDescription = "icon_search",
                        modifier = Modifier
                            .padding(10.dp)
                            .clickable { getConditions(cityName, context, stateDate) }
                    )
                }
            }
        }
    }
}


@Preview(showBackground = true)
@Composable
fun MyBackgroundView() {
    WeatherComposeTheme {
        //MainScreen()
    }
}

fun getTemperature(name: String, context: Context, mState: MutableState<String>) {
    val url = "https://api.weatherapi.com/v1/current.json" +
            "?key=$API_KEY&" +
            "q=$name" +
            "&aqi=no"
    val queue = Volley.newRequestQueue(context)
    val stringRequest = StringRequest(
        Request.Method.GET,
        url,
        { response ->
            val obj = JSONObject(response)
            val temp = obj.getJSONObject("current")
            mState.value = temp.getString("temp_c")
            Log.d("MyLog", "Response: ${temp.getString("temp_c")}")
        },
        {
            Log.d("MyLog", "Volley error: $it")
        }
    )
    queue.add(stringRequest)
}

fun getConditions(name: String, context: Context, mState: MutableState<String>) {
    val url = "https://api.weatherapi.com/v1/current.json" +
            "?key=$API_KEY&" +
            "q=$name" +
            "&aqi=no"
    val queue = Volley.newRequestQueue(context)
    val stringRequest = StringRequest(
        Request.Method.GET,
        url,
        { response ->
            val obj = JSONObject(response)
            val temp = obj.getJSONObject("current")
            mState.value = temp.getString("last_updated")
            //Log.d("MyLog", "Response: ${temp.getString("last_updated")}")
        },
        {
            Log.d("MyLog", "Volley error: $it")
        }
    )
    queue.add(stringRequest)
}