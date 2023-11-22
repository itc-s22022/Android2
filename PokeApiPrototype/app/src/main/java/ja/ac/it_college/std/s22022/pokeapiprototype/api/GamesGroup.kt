package ja.ac.it_college.std.s22022.pokeapiprototype.api

import io.ktor.client.call.body
import ja.ac.it_college.std.s22022.pokeapiprototype.api.model.Generation

object GamesGroup {
    /**
     * 世代情報を取る
     */
    suspend fun getGeneration(gen: Int): Generation {
        return Client.get("/generation/$gen/").body()
    }
}