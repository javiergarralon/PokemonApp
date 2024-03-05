package com.bakanito.developedwithkotlin.ui.view

import com.bakanito.developedwithkotlin.core.FormatNumber.toDecimals
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bakanito.developedwithkotlin.databinding.ActivityPokemonInfoBinding
import com.bakanito.developedwithkotlin.domain.model.Pokemon
import com.google.gson.Gson
import com.squareup.picasso.Picasso

class PokemonInfoActivity : AppCompatActivity() {

    private lateinit var binding: ActivityPokemonInfoBinding

    private lateinit var pokemon: Pokemon

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPokemonInfoBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val intent = intent
        val pokemonJson = intent.getStringExtra("pokemonJson")

        if (!pokemonJson.isNullOrEmpty()) {
            val gson = Gson()
            pokemon = gson.fromJson(pokemonJson, Pokemon::class.java)

            binding.tvId.text = pokemon.id.padStart(3,'0')
            binding.tvName.text = pokemon.name.replaceFirstChar { it.titlecase() }
            binding.tvHeight.text = "Altura: ${toDecimals(pokemon.height)}m"
            binding.tvWeight.text = "Peso: ${toDecimals(pokemon.weight)}kg"
            Picasso.get().load(pokemon.sprites.front_default).into(binding.ivFrontDefault)
            Picasso.get().load(pokemon.sprites.back_default).into(binding.ivBackDefault)
            Picasso.get().load(pokemon.sprites.front_shiny).into(binding.ivFrontShiny)
            Picasso.get().load(pokemon.sprites.back_shiny).into(binding.ivBackShiny)
        }
    }
}