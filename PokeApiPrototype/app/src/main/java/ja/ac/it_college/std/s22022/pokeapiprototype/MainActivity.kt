package ja.ac.it_college.std.s22022.pokeapiprototype

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import ja.ac.it_college.std.s22022.pokeapiprototype.ui.theme.PokemonQuizTheme


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PokemonQuizTheme {
                PokeNavigation()
            }
        }
    }
}