package com.weathercompose.data.models

import com.google.gson.annotations.SerializedName

data class HourItem(

	@field:SerializedName("cloud")
	val cloud: Int? = null,

	@field:SerializedName("wind_kph")
	val windKph: Double? = null,

	@field:SerializedName("feelslike_c")
	val feelslikeC: Float? = null,

	@field:SerializedName("condition")
	val condition: Condition? = null,

	@field:SerializedName("time_epoch")
	val timeEpoch: Int? = null,

	@field:SerializedName("is_day")
	val isDay: Int? = null,

	@field:SerializedName("humidity")
	val humidity: Int? = null,

	@field:SerializedName("time")
	val time: String? = null,

	@field:SerializedName("temp_c")
	val tempC: Double? = null
)