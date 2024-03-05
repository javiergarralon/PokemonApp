package com.bakanito.developedwithkotlin.ui.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.widget.SearchView.OnQueryTextListener
import androidx.activity.viewModels
import androidx.core.view.isVisible
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.GridLayoutManager
import com.bakanito.developedwithkotlin.core.adapter.PokedexAdapter
import com.bakanito.developedwithkotlin.databinding.ActivityPokedexBinding
import com.bakanito.developedwithkotlin.domain.model.Pokemon
import com.bakanito.developedwithkotlin.ui.viewmodel.PokedexViewModel
import com.google.gson.Gson
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class PokedexActivity : AppCompatActivity(), OnQueryTextListener {

    private lateinit var binding: ActivityPokedexBinding
    private val pokedexViewModel: PokedexViewModel by viewModels()
    private var pokedex = mutableListOf<Pokemon>()
    private lateinit var adapter: PokedexAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPokedexBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.svPokemonFilter.setOnQueryTextListener(this)



        pokedexViewModel.isLoading.observe(this, Observer {
            binding.progressBar.isVisible = it
        }
        )

        initRecyclerView()

        pokedexViewModel.onCreate()

        pokedexViewModel.pokedex.observe(this, Observer {
            pokedex = it as MutableList<Pokemon>
            adapter.updatePokedex(pokedex)
        })


    }

    private fun initRecyclerView() {
        adapter = PokedexAdapter(pokedex) { pokemon -> onItemSelected(pokemon) }
        binding.rvPokedex.layoutManager = GridLayoutManager(this, 2)
        binding.rvPokedex.adapter = adapter

    }

    private fun onItemSelected(pokemon: Pokemon) {
        val gson = Gson()
        val pokmonJson = gson.toJson(pokemon)

        val intent = Intent(this, PokemonInfoActivity::class.java)
        intent.putExtra("pokemonJson", pokmonJson)
        startActivity(intent)
    }

    override fun onQueryTextSubmit(query: String?): Boolean {
        return true
    }

    override fun onQueryTextChange(newText: String?): Boolean {
        var query = ""
        if (!newText.isNullOrEmpty()) {
            query = newText.lowercase()
        }
        val pokedexFiltered =
            pokedex.filter { pokemon -> pokemon.name.contains(query) }
        adapter.updatePokedex(pokedexFiltered)

        return true
    }
}