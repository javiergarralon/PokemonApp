package com.bakanito.developedwithkotlin.data.response

import com.bakanito.developedwithkotlin.data.model.PokedexModel
import com.google.gson.annotations.SerializedName

data class PokedexResponse(
    @SerializedName("count") val pokedexCount: Int,
    @SerializedName("next") val nextUrl: String?,
    @SerializedName("previous") val previousUrl: String?,
    @SerializedName("results") val pokedex: List<PokedexModel>
)