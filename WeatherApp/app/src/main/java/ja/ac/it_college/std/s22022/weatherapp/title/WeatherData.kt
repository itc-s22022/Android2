package ja.ac.it_college.std.s22022.weatherapp.title

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable

data class WeatherData(
    val list: List<WeatherInfo>
)

data class WeatherInfo(
    val dt: Long,
    val main: Main,
    val weather: List<Weather>
)

data class Main(
    val temp: Double
)

data class Weather(
    val description: String,
    val icon: String
)


@Composable
fun WeatherInfo(weatherData: WeatherData) {
    // 最初の WeatherInfo を取得
    val firstWeatherInfo = weatherData.list.firstOrNull()

    // 天気情報を表示するための UI コード
    if (firstWeatherInfo != null) {
        Column {
            Text(text = "気温: ${firstWeatherInfo.main.temp}")
            Text(text = "天気: ${firstWeatherInfo.weather[0].description}")
            // 他にも必要な UI 要素を追加
        }
    } else {
        Text(text = "天気情報がありません")
    }
}