package com.bakanito.developedwithkotlin.domain

import com.bakanito.developedwithkotlin.data.PokedexRepository
import com.bakanito.developedwithkotlin.data.database.entities.toDatabase
import com.bakanito.developedwithkotlin.domain.model.Pokemon
import javax.inject.Inject

class GetPokemonUseCase @Inject constructor(private val repository: PokedexRepository) {

    suspend operator fun invoke(): List<Pokemon> {
        //Obtengo toda la pokedex de la base de datos
        val pokedex = repository.getPokedexFromDatabase()
        //Llamada por url a la api uno por uno e inserción database
        if (!pokedex.isNullOrEmpty()) {
            repository.clearPokemons()
            pokedex.forEach { pokedexInfo ->
                var pokemon = repository.getPokemonFromApi(pokedexInfo.url)
                repository.insertPokemon(pokemon.toDatabase())
            }
            return repository.getPokemonsFromDatabase()
        }
        return emptyList()
    }
}