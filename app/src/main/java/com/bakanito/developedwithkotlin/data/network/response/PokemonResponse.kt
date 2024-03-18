package com.bakanito.developedwithkotlin.data.network.response

import com.google.gson.annotations.SerializedName

data class PokemonResponse(
    @SerializedName("id") val id: String?,
    @SerializedName("name") val name: String?,
    @SerializedName("height") val height: String,
    @SerializedName("weight") val weight: String,
    @SerializedName("sprites") val sprites: SpriteResponse
)