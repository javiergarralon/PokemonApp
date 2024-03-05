package com.bakanito.developedwithkotlin.data.database.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.bakanito.developedwithkotlin.domain.model.Pokemon

@Entity(tableName = "pokemon_table")
data class PokemonEntity(
    @PrimaryKey(autoGenerate = false)
    @ColumnInfo(name = "id") val id:String,
    @ColumnInfo(name = "name") val name: String,
    @ColumnInfo(name = "height") val height: String,
    @ColumnInfo(name = "weight") val weight: String,
    @ColumnInfo(name = "front_default") val front_default: String,
    @ColumnInfo(name = "back_default") val back_default: String,
    @ColumnInfo(name = "front_shiny") val front_shiny: String,
    @ColumnInfo(name = "back_shiny") val back_shiny: String
)

fun Pokemon.toDatabase() =
    PokemonEntity(
        id = id,
        name = name,
        height = height,
        weight = weight,
        front_default = sprites.front_default,
        back_default = sprites.back_default,
        front_shiny = sprites.front_shiny,
        back_shiny = sprites.back_shiny
    )