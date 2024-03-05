package com.bakanito.developedwithkotlin.data.model

data class PokemonModel(
    val id: String,
    val name: String,
    val height: String,
    val weight: String,
    val back_default: String,
    val back_shiny: String,
    val front_default: String,
    val front_shiny: String
)