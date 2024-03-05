package com.bakanito.developedwithkotlin.data

import com.bakanito.developedwithkotlin.data.database.dao.PokedexDao
import com.bakanito.developedwithkotlin.data.database.dao.PokemonDao
import com.bakanito.developedwithkotlin.data.database.entities.PokedexEntity
import com.bakanito.developedwithkotlin.data.database.entities.PokemonEntity
import com.bakanito.developedwithkotlin.data.network.PokedexService
import com.bakanito.developedwithkotlin.domain.model.Pokedex
import com.bakanito.developedwithkotlin.domain.model.Pokemon
import com.bakanito.developedwithkotlin.domain.model.toDomain
import javax.inject.Inject

class PokedexRepository @Inject constructor(
    private val api: PokedexService,
    private val pokedexDao: PokedexDao,
    private val pokemonDao: PokemonDao
) {

    suspend fun getPokedexFromApi(): List<Pokedex> {
        val response = api.getPokedex()
        return response.map { it.toDomain() }
    }

    suspend fun getPokedexFromDatabase(): List<Pokedex> {
        val response = pokedexDao.getAllPokedex()
        return response.map { it.toDomain() }
    }

    suspend fun insertPokedex(pokedex: List<PokedexEntity>) {
        pokedexDao.insertAll(pokedex)
    }

    suspend fun clearPokedex() {
        pokedexDao.deleteAllPokedex()
    }

    suspend fun getPokemonFromApi(url:String): Pokemon {
        val response = api.getPokemon(url)
        return response.toDomain()
    }

    suspend fun getPokemonsFromDatabase(): List<Pokemon> {
        val response = pokemonDao.getAllPokemons()
        return response.map { it.toDomain() }
    }

    suspend fun insertPokemon(pokemon: PokemonEntity) {
        pokemonDao.insert(pokemon)
    }

    suspend fun clearPokemons() {
        pokemonDao.deleteAllPokemons()
    }

}