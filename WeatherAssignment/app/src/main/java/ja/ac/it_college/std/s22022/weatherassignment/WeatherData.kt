package ja.ac.it_college.std.s22022.weatherassignment

import com.google.gson.annotations.SerializedName

data class WeatherData(
    val main: MainData,
    val weather: List<WeatherItem>,
    val wind: WindData,
    @SerializedName("rain")
    val precipitation: PrecipitationData?,
    @SerializedName("snow")
    val snow: SnowData?,
    val forecastTime: String
)

data class MainData(
    val temp: Double,
    @SerializedName("feels_like")
    val feelsLike: Double,
    val pressure: Double = 0.0,
    val humidity: Int = 0
)

data class WeatherItem(
    val description: String,
    val icon: String
)

data class WindData(
    val speed: Double,
    val deg: Double
)

data class PrecipitationData(
    @SerializedName("3h")
    val h3: Double
)

data class SnowData(
    @SerializedName("3h")
    val h3: Double
)
