package com.bakanito.developedwithkotlin.data.database.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.bakanito.developedwithkotlin.domain.model.Pokedex

@Entity(tableName = "pokedex_table")
data class PokedexEntity(
    @PrimaryKey(autoGenerate = false)
    @ColumnInfo(name = "name") val name: String,
    @ColumnInfo(name = "url") val url: String
)

fun Pokedex.toDatabase() =
    PokedexEntity(name = name, url = url)
