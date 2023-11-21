package ja.ac.it_college.std.s22022.pokeapiprototype.api.model

import kotlinx.serialization.Serializable

@Serializable
data class NamedAPIResource(
    val name: String,
    val url: String,
)

@Serializable
data class Name(
    val name: String,
    val language: NamedAPIResource
)