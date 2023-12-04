package ja.ac.it_college.std.s22022.weatherassignment

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import androidx.activity.viewModels
import android.os.Bundle
import android.widget.AdapterView
import android.widget.ArrayAdapter
import ja.ac.it_college.std.s22022.weatherassignment.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val viewModel: WeatherViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val prefectureNames = resources.getStringArray(R.array.prefecture_names)
        val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, prefectureNames)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        binding.spinnerPrefectures.adapter = adapter

        binding.buttonShowWeather.setOnClickListener {
            // Spinnerで選択されている都道府県を取得
            val selectedPrefecture = binding.spinnerPrefectures.selectedItem as String

            // DetailActivityに遷移するメソッドを呼び出し
            navigateToDetailActivity(selectedPrefecture)
        }

        // weatherDataを観察して、データが変更された際に実行されるコードを指定
        viewModel.weatherData.observe(this, { newWeatherData ->
            // 新しい天気情報をTextViewに表示
            binding.textView.text = newWeatherData
        })
    }

    private fun navigateToDetailActivity(selectedPrefecture: String) {
        val intent = Intent(this, DetailActivity::class.java)
        intent.putExtra("selectedPrefectureId", selectedPrefecture)
        startActivity(intent)
    }
}
