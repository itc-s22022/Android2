package ja.ac.it_college.std.s22022.pokeapiprototype.model


data class PokeQuiz (
    val imageUrl: String,
    val choices: List<String>,
    val correct: String
)