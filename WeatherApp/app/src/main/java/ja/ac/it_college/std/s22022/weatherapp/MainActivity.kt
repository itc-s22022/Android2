package ja.ac.it_college.std.s22022.weatherapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import ja.ac.it_college.std.s22022.weatherapp.title.TitleScene
import ja.ac.it_college.std.s22022.weatherapp.ui.theme.WeatherAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            WeatherAppTheme {
                TitleScene()
            }
        }
    }
}





