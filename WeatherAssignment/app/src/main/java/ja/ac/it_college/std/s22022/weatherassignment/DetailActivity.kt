package ja.ac.it_college.std.s22022.weatherassignment

import android.annotation.SuppressLint
import android.content.res.Resources
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import ja.ac.it_college.std.s22022.weatherassignment.databinding.ActivityDetailBinding
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.launch
import org.json.JSONObject
import java.net.URLEncoder
import java.net.URL

class DetailActivity : AppCompatActivity() {

    companion object {
        private const val WEATHER_INFO_URL =
            "https://api.openweathermap.org/data/2.5/forecast?lang=ja"
        private const val DEBUG_TAG = "DetailActivity"
    }

    private lateinit var binding: ActivityDetailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Intentから都道府県名を取得
        val selectedPrefecture = intent.getStringExtra("selectedPrefectureId") ?: ""
        binding.textViewPrefecture.text = selectedPrefecture


        // Find the city with the given name in cityList
        val city = cityList.firstOrNull { it.name == selectedPrefecture }

        // Check if the city is found
        if (city != null) {
            val apiKey: String = BuildConfig.APP_ID
            // Encode the city name
            val encodedCityId = URLEncoder.encode(city.cityid.toString(), "UTF-8")
            val apiUrl = "$WEATHER_INFO_URL&id=$encodedCityId&appid=$apiKey"
            // APIリクエストURLの構築

            // fetchWeatherDataメソッドに都道府県名を渡す
            lifecycleScope.launch {
                val weatherData = fetchWeatherData(apiUrl)
                // 非同期処理が完了したらWeatherDataを利用できる
                if (weatherData != null) {
                    displayForecastDetails(weatherData)
                }
            }
        } else {
            Log.e(DEBUG_TAG, "City not found for prefecture: $selectedPrefecture")
        }
    }

    private fun getWeatherDetails(apiResponse: JSONObject): WeatherData? {
        return try {
            val mainObj = apiResponse.optJSONObject("main")
            val weatherArray = apiResponse.optJSONArray("weather")
            val windObj = apiResponse.optJSONObject("wind")

            // メイン情報
            val temp = mainObj?.optDouble("temp") ?: 0.0
            val feelsLike = mainObj?.optDouble("feels_like") ?: 0.0
            val pressure = mainObj?.optDouble("pressure") ?: 0.0
            val humidity = mainObj?.optInt("humidity") ?: 0

            // 天気情報
            val description = weatherArray?.optJSONObject(0)?.optString("description") ?: ""
            val icon = weatherArray?.optJSONObject(0)?.optString("icon") ?: ""

            // 風の情報
            val windSpeed = windObj?.optDouble("speed") ?: 0.0
            val windDeg = windObj?.optDouble("deg") ?: 0.0

            // 降水確率
            val precipitation = apiResponse.optJSONObject("rain")?.optDouble("3h") ?: 0.0

            // 積雪量
            val snowfall = apiResponse.optJSONObject("snow")?.optDouble("3h") ?: 0.0

            // 予測時刻
            val forecastTime = apiResponse.optString("dt_txt")

            WeatherData(
                main = MainData(temp = temp, feelsLike = feelsLike, pressure = pressure, humidity = humidity),
                weather = listOf(WeatherItem(description = description, icon = icon)),
                wind = WindData(speed = windSpeed, deg = windDeg),
                precipitation = PrecipitationData(h3 = precipitation),
                snow = SnowData(h3 = snowfall),
                forecastTime = forecastTime
            )
        } catch (e: Exception) {
            Log.e(DEBUG_TAG, "Error parsing weather details: ${e.message}")
            null
        }
    }


    private suspend fun fetchWeatherData(apiUrl: String): WeatherData? {
        return try {
            // asyncを使用して非同期処理を行う
            val weatherDataDeferred = lifecycleScope.async(Dispatchers.IO) {
                val apiResponse = URL(apiUrl).readText()
                Log.d(DEBUG_TAG, "API_RESPONSE: $apiResponse")

                val json = JSONObject(apiResponse)
                getWeatherDetails(json)
            }

            // awaitを使用して結果を取得
            val weatherData = weatherDataDeferred.await()

            // 取得した天気データをUIに表示
            if (weatherData != null) {
                displayForecastDetails(weatherData)
            }

            weatherData
        } catch (e: Exception) {
            Log.e(DEBUG_TAG, "Error fetching data from API: ${e.message}")
            null
        }
    }




    private fun parseWeatherData(apiResponse: String): WeatherData? {
        return try {
            val json = JSONObject(apiResponse)
            val mainObj = json.optJSONObject("main")

            // "temp" フィールドがあるか確認し、値を取得
            val temp = mainObj?.optDouble("temp") ?: 0.0


            // 他のフィールドも同様に取得可能

            WeatherData(
                main = MainData(temp = temp, feelsLike = 0.0, pressure = 0.0, humidity = 0),
                weather = listOf(WeatherItem(description = "", icon = "")),
                wind = WindData(speed = 0.0, deg = 0.0),
                precipitation = PrecipitationData(h3 = 0.0), // 降水確率
                snow = SnowData(h3 = 0.0), // 積雪量
                forecastTime = "予測時刻"
            )
        } catch (e: Exception) {
            Log.e(DEBUG_TAG, "Error fetching data from API: ${e.message}")
            e.printStackTrace()
            null
        }
    }

    @SuppressLint("StringFormatMatches")
    private fun displayForecastDetails(weatherData: WeatherData) {
        val resources: Resources = resources
        val mainInfo = weatherData.main

        // 気温
        val temperature = mainInfo.temp - 273.15  // ケルビンから摂氏に変換
        binding.textViewTemperature.text = resources.getString(R.string.temperature_label, temperature)

        // 体感気温
        binding.textViewFeelsLike.text = resources.getString(R.string.feels_like_label, mainInfo.feelsLike.toString())

        // 気圧
        binding.textViewPressure.text = resources.getString(R.string.pressure_label, mainInfo.pressure.toString())

        // 湿度
        binding.textViewHumidity.text = resources.getString(R.string.humidity_label, mainInfo.humidity.toString())

        // 天気
        binding.textViewWeather.text = resources.getString(R.string.weather_label, weatherData.weather[0].description)

        // 風速
        binding.windspeedlabel.text = resources.getString(R.string.wind_speed_label, weatherData.wind.speed.toString())

        // 風向
        binding.winddirectionlabel.text = resources.getString(R.string.wind_direction_label, weatherData.wind.deg.toString())

        // 降水確率 (rain)
        val precipitation = weatherData.precipitation?.h3 ?: 0.0
        binding.precipitationProbabilityLabel.text = resources.getString(R.string.precipitation_probability_label, precipitation.toString())

        // 積雪量 (snow)
        val snowfall = weatherData.snow?.h3 ?: 0.0
        binding.snowfallLabel.text = resources.getString(R.string.snowfall_label, snowfall.toString())

        // 予測時刻
        binding.forecastTimeLabel.text = resources.getString(R.string.forecast_time_label, weatherData.forecastTime)

        // 他のデータも同様にUIにセット可能
    }

}
