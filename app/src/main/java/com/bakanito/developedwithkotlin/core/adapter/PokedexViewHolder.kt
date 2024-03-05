package com.bakanito.developedwithkotlin.core.adapter

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.bakanito.developedwithkotlin.databinding.ItemPokemonBinding
import com.bakanito.developedwithkotlin.domain.model.Pokemon
import com.squareup.picasso.Picasso

class PokedexViewHolder(view: View) : RecyclerView.ViewHolder(view) {

    val binding = ItemPokemonBinding.bind(view)

    fun render(pokemon: Pokemon, OnClickListener: (Pokemon) -> Unit) {
        binding.tvPokemonName.text = pokemon.name.replaceFirstChar { it.titlecase() }
        binding.tvPokemonIndex.text = pokemon.id.padStart(3,'0')
        //Glide.with(binding.ivPokemonPhoto.context).load(pokemonModel.frontImg).into(binding.ivPokemonPhoto)
        Picasso.get().load(pokemon.sprites.front_default).into(binding.ivPokemonPhoto)

        itemView.setOnClickListener { OnClickListener(pokemon) }
    }
}