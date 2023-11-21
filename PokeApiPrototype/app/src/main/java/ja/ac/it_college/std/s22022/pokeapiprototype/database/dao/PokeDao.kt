package ja.ac.it_college.std.s22022.pokeapiprototype.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import ja.ac.it_college.std.s22022.pokeapiprototype.database.entity.Poke

@Dao
interface PokeDao {
    /**
     * 世代番号[generation]をもとにポケモンのデータを取得する
     */
    @Query("SELECT * FROM poke WHERE generation = :generation")
    fun findByGeneration(generation: Int): List<Poke>

    /**
     * 1件のデータ登録
     */
    @Insert
    fun insert(poke: Poke)

    /**
     * 複数件のデータを一括で登録
     */
    @Insert
    fun insertAll(pokeList: List<Poke>)

    /**
     * 世代番号[generation]をもとに一括で削除する
     */
    @Query("DELETE FROM poke WHERE generation = :generation")
    fun deleteByGeneration(generation: Int)
}