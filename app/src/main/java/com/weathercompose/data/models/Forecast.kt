package com.weathercompose.data.models

import com.google.gson.annotations.SerializedName

data class Forecast(

	@field:SerializedName("forecastday")
	val forecastday: List<ForecastdayItem?>? = null
)