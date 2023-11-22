package ja.ac.it_college.std.s22022.pokeapiprototype.api.model

import kotlinx.serialization.Serializable

@Serializable
data class PokemonSpecies(
    val id: Int,
    val varieties: List<PokemonSpeciesVariety>
)
