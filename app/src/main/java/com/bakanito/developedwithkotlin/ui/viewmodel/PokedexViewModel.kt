package com.bakanito.developedwithkotlin.ui.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.bakanito.developedwithkotlin.domain.GetPokedexUseCase
import com.bakanito.developedwithkotlin.domain.GetPokemonUseCase
import com.bakanito.developedwithkotlin.domain.model.Pokemon
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class PokedexViewModel @Inject constructor(
    private val getPokedexUseCase: GetPokedexUseCase,
    private val getPokemonUseCase: GetPokemonUseCase
) :
    ViewModel() {

    val isLoading = MutableLiveData<Boolean>()
    val pokedex = MutableLiveData<List<Pokemon>?>()

    fun onCreate() {
        viewModelScope.launch {
            isLoading.postValue(true)
            val pokedexInfo = getPokedexUseCase()
            if (!pokedexInfo.isNullOrEmpty()) {
                //Carga Pokémon
                pokedex.postValue(getPokemonUseCase())
                isLoading.postValue(false)
            }
        }
    }
}