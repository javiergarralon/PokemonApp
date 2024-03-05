package com.bakanito.developedwithkotlin.domain.model

import com.bakanito.developedwithkotlin.data.database.entities.PokemonEntity
import com.bakanito.developedwithkotlin.data.model.PokemonModel
import com.bakanito.developedwithkotlin.data.response.SpriteResponse
import java.io.Serializable

data class Pokemon(
    val id: String,
    val name: String,
    val height: String,
    val weight: String,
    val sprites: SpriteResponse
): Serializable

fun PokemonModel.toDomain() = Pokemon(
    id,
    name,
    height,
    weight,
    sprites = SpriteResponse(back_default, back_shiny, front_default, front_shiny)
)

fun PokemonEntity.toDomain() = Pokemon(
    id,
    name,
    height,
    weight,
    sprites = SpriteResponse(back_default, back_shiny, front_default, front_shiny)
)