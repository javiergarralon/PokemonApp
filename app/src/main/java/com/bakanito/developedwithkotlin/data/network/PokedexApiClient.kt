package com.bakanito.developedwithkotlin.data.network

import com.bakanito.developedwithkotlin.data.network.response.PokedexResponse
import com.bakanito.developedwithkotlin.data.network.response.PokemonResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Url

interface PokedexApiClient {
    @GET("v2/pokemon?offset=0&limit=151")
    suspend fun getPokedex(): Response<PokedexResponse>

    @GET
    suspend fun getPokemon(@Url url:String): Response<PokemonResponse>
}