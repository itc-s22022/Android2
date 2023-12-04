package ja.ac.it_college.std.s22022.weatherassignment

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class WeatherViewModel : ViewModel() {

    private val _weatherData = MutableLiveData<String>()
    val weatherData: LiveData<String>
        get() = _weatherData

    private val viewModelJob = Job()
    private val viewModelScope = CoroutineScope(Dispatchers.Main + viewModelJob)

    fun getWeatherForPrefecture(prefecture: String) {
        viewModelScope.launch {
            // 仮の非同期処理（API呼び出しの模倣）
            // 実際のAPI呼び出しはここに入ります。ここでは単に2秒待機してダミーデータを取得しています。
            withContext(Dispatchers.IO) {
                delay(2000)
                val dummyWeatherInfo = "天気情報"
                updateWeatherData(dummyWeatherInfo)
            }
        }
    }

    private fun updateWeatherData(newData: String) {
        _weatherData.value = newData
    }

    override fun onCleared() {
        super.onCleared()
        viewModelJob.cancel()
    }
}
