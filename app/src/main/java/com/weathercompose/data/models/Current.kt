package com.weathercompose.data.models

import com.google.gson.annotations.SerializedName

data class Current(

	@field:SerializedName("cloud")
	val cloud: Int? = null,

	@field:SerializedName("feelslike_c")
	val feelslikeC: Double? = null,

	@field:SerializedName("uv")
	val uv: Int? = null,

	@field:SerializedName("last_updated")
	val lastUpdated: String? = null,

	@field:SerializedName("condition")
	val condition: Condition? = null,

	@field:SerializedName("is_day")
	val isDay: Int? = null,

	@field:SerializedName("humidity")
	val humidity: Int? = null,

	@field:SerializedName("temp_c")
	val tempC: Double? = null,

	@field:SerializedName("temp_f")
	val tempF: Double? = null
)