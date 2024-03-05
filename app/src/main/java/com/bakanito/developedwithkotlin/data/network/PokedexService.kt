package com.bakanito.developedwithkotlin.data.network

import com.bakanito.developedwithkotlin.data.model.PokedexModel
import com.bakanito.developedwithkotlin.data.model.PokemonModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class PokedexService @Inject constructor(private val api: PokedexApiClient) {

    suspend fun getPokedex(): List<PokedexModel> {
        return withContext(Dispatchers.IO) {
            val response = api.getPokedex()
            val data = response.body()
            data?.pokedex ?: emptyList()
        }
    }

    suspend fun getPokemon(url: String): PokemonModel {
        return withContext(Dispatchers.IO) {
            val response = api.getPokemon(url)
            val data = response.body()
            PokemonModel(
                data?.id ?: "",
                data?.name ?: "",
                data?.height ?: "",
                data?.weight ?: "",
                data?.sprites?.back_default ?: "",
                data?.sprites?.back_shiny ?: "",
                data?.sprites?.front_default ?: "",
                data?.sprites?.front_shiny ?: ""
            )
        }
    }
}

