package com.bakanito.developedwithkotlin.domain

import com.bakanito.developedwithkotlin.data.PokedexRepository
import com.bakanito.developedwithkotlin.data.database.entities.toDatabase
import com.bakanito.developedwithkotlin.domain.model.Pokedex
import javax.inject.Inject

class GetPokedexUseCase @Inject constructor(private val repository: PokedexRepository) {

    suspend operator fun invoke(): List<Pokedex> {
        var pokedex = repository.getPokedexFromApi()
        return if (!pokedex.isNullOrEmpty()) {
            repository.clearPokedex()
            repository.insertPokedex(pokedex.map { it.toDatabase() })
            pokedex
        } else {
            pokedex = repository.getPokedexFromDatabase()
            pokedex
        }
    }

}
