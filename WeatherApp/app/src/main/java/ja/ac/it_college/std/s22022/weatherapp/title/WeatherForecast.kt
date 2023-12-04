package ja.ac.it_college.std.s22022.weatherapp.title

data class WeatherForecast(
    val city: String,
    val forecastList: List<WeatherInfo>,
    val weatherIconList: List<WeatherIcon>
)
