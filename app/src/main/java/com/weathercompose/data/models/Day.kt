package com.weathercompose.data.models

import com.google.gson.annotations.SerializedName

data class Day(

	@field:SerializedName("condition")
	val condition: Condition? = null,

	@field:SerializedName("avgtemp_c")
	val avgtempC: Double? = null,

	@field:SerializedName("maxwind_mph")
	val maxwindMph: Double? = null,

	@field:SerializedName("maxtemp_c")
	val maxtempC: Double? = null,

	@field:SerializedName("maxtemp_f")
	val maxtempF: Double? = null,

	@field:SerializedName("mintemp_c")
	val mintempC: Double? = null,

	@field:SerializedName("mintemp_f")
	val mintempF: Double? = null
)