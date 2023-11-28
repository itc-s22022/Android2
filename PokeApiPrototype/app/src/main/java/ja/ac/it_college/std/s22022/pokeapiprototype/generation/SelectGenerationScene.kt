package ja.ac.it_college.std.s22022.pokeapiprototype.generation

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import ja.ac.it_college.std.s22022.pokeapiprototype.R
import ja.ac.it_college.std.s22022.pokeapiprototype.ui.theme.PokemonQuizTheme

@Composable
fun SelectGenerationScene(modifier: Modifier = Modifier, onGenerationSelected: (Int) -> Unit = {}) {
    Surface(modifier) {
        LazyColumn(modifier = Modifier.fillMaxWidth()) {
            items(1) {
                Generation(
                    generation = 9,
                    seriesName = "スカーレット/バイオレット",
                    onGenerationSelected = onGenerationSelected
                )
            }
        }
    }
}

@Composable
fun Generation(generation: Int, seriesName: String, onGenerationSelected: (Int) -> Unit = {}) {
    // 背景色・文字色を全体的に設定するために使ってる
    Surface(
        color = MaterialTheme.colorScheme.tertiary,
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
            .clickable { onGenerationSelected(generation) }
    ) {
        Column(
            modifier = Modifier
                .padding(8.dp)

        ) {
            // 第?世代
            Text(
                text = stringResource(id = R.string.generation, generation),
                style = MaterialTheme.typography.titleLarge
            )
            // シリーズ名
            Text(
                text = seriesName,
                style = MaterialTheme.typography.titleMedium
            )
        }
    }
}

@Preview(showBackground = true, widthDp = 320)
@Composable
fun SelectGenerationScenePreview() {
    PokemonQuizTheme {
        SelectGenerationScene(Modifier.fillMaxSize())
    }
}