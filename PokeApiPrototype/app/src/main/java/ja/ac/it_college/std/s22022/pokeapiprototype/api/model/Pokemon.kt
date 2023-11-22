package ja.ac.it_college.std.s22022.pokeapiprototype.api.model

import kotlinx.serialization.Serializable

@Serializable
data class Pokemon(
    val id: Int,
    val sprites: PokemonSprites
)
