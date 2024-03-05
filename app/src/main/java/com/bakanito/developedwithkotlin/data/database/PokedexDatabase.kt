package com.bakanito.developedwithkotlin.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.bakanito.developedwithkotlin.data.database.dao.PokedexDao
import com.bakanito.developedwithkotlin.data.database.dao.PokemonDao
import com.bakanito.developedwithkotlin.data.database.entities.PokedexEntity
import com.bakanito.developedwithkotlin.data.database.entities.PokemonEntity

@Database(entities = [PokedexEntity::class, PokemonEntity::class], version = 2)
abstract class PokedexDatabase : RoomDatabase() {

    abstract fun getPokedexDao(): PokedexDao
    abstract fun getPokemonDao(): PokemonDao
}