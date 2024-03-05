package com.bakanito.developedwithkotlin.data.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.bakanito.developedwithkotlin.data.database.entities.PokedexEntity

@Dao
interface PokedexDao {

    @Query("SELECT * FROM pokedex_table")
    suspend fun getAllPokedex(): List<PokedexEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(fullPokedex: List<PokedexEntity>)

    @Query("DELETE FROM pokedex_table")
    suspend fun deleteAllPokedex()
}