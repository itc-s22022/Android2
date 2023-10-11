package ja.ac.it_college.std.s22022.ktorsample.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class WeatherInfo(
    @SerialName("coord")
    val coordinates: Coordinate,

    val weather: List<Weather>,

    @SerialName("name")
    val cityName: String,
)

@Serializable
data class Coordinate(
    @SerialName("lon")
    val longitude: Double,

    @SerialName("lat")
    val latitude: Double,
)
@Serializable
data class Weather(
    val id: Int,

    @SerialName("main")
    val groupName: String,

    val description: String,

    val icon: String,
)