package ja.ac.it_college.std.s22022.weatherassignment

//// OpenWeatherMapApiClient.kt
//import okhttp3.OkHttpClient
//import okhttp3.Request
//
//class OpenWeatherMapApiClient(private val apiKey: String) {
//
//    fun getWeatherForecast(cityId: Int): String {
//        val url = "https://api.openweathermap.org/data/2.5/forecast?id=$cityId&appid=$apiKey"
//        val request = Request.Builder().url(url).build()
//
//        OkHttpClient().newCall(request).execute().use { response ->
//            return response.body?.string() ?: ""
//        }
//    }
//}