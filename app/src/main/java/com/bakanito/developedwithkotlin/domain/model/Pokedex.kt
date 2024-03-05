package com.bakanito.developedwithkotlin.domain.model

import com.bakanito.developedwithkotlin.data.database.entities.PokedexEntity
import com.bakanito.developedwithkotlin.data.model.PokedexModel

data class Pokedex(
    val name: String,
    val url: String
)

fun PokedexModel.toDomain() = Pokedex(name, url)
fun PokedexEntity.toDomain() = Pokedex(name, url)