package com.weathercompose.data.current

import androidx.annotation.Keep

import com.google.gson.annotations.SerializedName
@Keep
data class Response(

	@field:SerializedName("current")
	val current: Current? = null,

	@field:SerializedName("location")
	val location: Location? = null
)

data class Current(

	@field:SerializedName("feelslike_c")
	val feelslikeC: Double? = null,

	@field:SerializedName("uv")
	val uv: Double? = null,

	@field:SerializedName("last_updated")
	val lastUpdated: String? = null,

	@field:SerializedName("wind_degree")
	val windDegree: Int? = null,

	@field:SerializedName("is_day")
	val isDay: Int? = null,

	@field:SerializedName("wind_dir")
	val windDir: String? = null,

	@field:SerializedName("temp_c")
	val tempC: Double? = null,

	@field:SerializedName("temp_f")
	val tempF: Double? = null,

	@field:SerializedName("cloud")
	val cloud: Int? = null,

	@field:SerializedName("wind_kph")
	val windKph: Double? = null,

	@field:SerializedName("condition")
	val condition: Condition? = null,

	@field:SerializedName("wind_mph")
	val windMph: Double? = null,

	@field:SerializedName("humidity")
	val humidity: Int? = null
)

data class Condition(

	@field:SerializedName("code")
	val code: Int? = null,

	@field:SerializedName("icon")
	val icon: String? = null,

	@field:SerializedName("text")
	val text: String? = null
)

data class Location(

	@field:SerializedName("localtime")
	val localtime: String? = null,

	@field:SerializedName("country")
	val country: String? = null,

	@field:SerializedName("localtime_epoch")
	val localtimeEpoch: Int? = null,

	@field:SerializedName("name")
	val name: String? = null,

	@field:SerializedName("lon")
	val lon: Double? = null,

	@field:SerializedName("region")
	val region: String? = null,

	@field:SerializedName("lat")
	val lat: Double? = null,

	@field:SerializedName("tz_id")
	val tzId: String? = null
)
