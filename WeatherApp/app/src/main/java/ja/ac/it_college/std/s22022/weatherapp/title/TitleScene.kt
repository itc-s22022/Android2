package ja.ac.it_college.std.s22022.weatherapp.title

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import ja.ac.it_college.std.s22022.weatherapp.R
import ja.ac.it_college.std.s22022.weatherapp.ui.theme.WeatherAppTheme


@Composable
fun TitleScene(modifier: Modifier = Modifier) {
    Surface(modifier) {
        Column (
            modifier = Modifier.fillMaxSize()
        ) {
            Text(
                text = stringResource(id = R.string.app_name),
                textAlign = TextAlign.Center,
                style = MaterialTheme.typography.displayLarge,
                modifier = Modifier.padding(vertical = 24.dp)
            )

            // Add Weather Forecast Composable
            WeatherForecast()
        }
    }
}
@Composable
fun WeatherForecast() {
    // apiKeyを使用して天気予報コンポーザブルを構築
    // ここに3時間ごとの5日間の天気予報を表示するコードを追加
    // OpenWeatherMap APIなどを使用してデータを取得し、表示するためのComposablesを構築する
    // 例: Text("3時間ごとの天気予報: Day 1 - 晴れ, Day 2 - 曇り, ...")
}
@Preview(showBackground = true, widthDp = 320)
@Composable
fun TitleScenePreview() {
    WeatherAppTheme {
        TitleScene(Modifier.fillMaxSize())
    }
}






















//import androidx.compose.foundation.layout.Column
//import androidx.compose.foundation.layout.fillMaxSize
//import androidx.compose.foundation.layout.padding
//import androidx.compose.material3.MaterialTheme
//import androidx.compose.material3.Surface
//import androidx.compose.material3.Text
//import androidx.compose.runtime.Composable
//import androidx.compose.ui.Modifier
//import androidx.compose.ui.res.stringResource
//import androidx.compose.ui.text.style.TextAlign
//import androidx.compose.ui.tooling.preview.Preview
//import androidx.compose.ui.unit.dp
//import ja.ac.it_college.std.s22022.weatherapp.R
//import ja.ac.it_college.std.s22022.weatherapp.ui.theme.WeatherAppTheme
//
//@Composable
//fun TitleScene(modifier: Modifier = Modifier) {
//    Surface(modifier) {
//        Column (
//            modifier = Modifier.fillMaxSize()
//        ) {
//            Text(
//                text = stringResource(id = R.string.app_name),
//                textAlign = TextAlign.Center,
//                style = MaterialTheme.typography.displayLarge,
//                modifier = Modifier.padding(vertical = 24.dp)
//            )
//
//            // Add Weather Forecast Composable
//            WeatherForecast()
//        }
//    }
//}
//
//@Composable
//fun WeatherForecast() {
//    // apiKeyを使用して天気予報コンポーザブルを構築
//    // ここに3時間ごとの5日間の天気予報を表示するコードを追加
//    // OpenWeatherMap APIなどを使用してデータを取得し、表示するためのComposablesを構築する
//    // 例: Text("3時間ごとの天気予報: Day 1 - 晴れ, Day 2 - 曇り, ...")
//}
//
//@Preview(showBackground = true, widthDp = 320)
//@Composable
//fun TitleScenePreview() {
//    WeatherAppTheme {
//        TitleScene(Modifier.fillMaxSize())
//    }
//}

