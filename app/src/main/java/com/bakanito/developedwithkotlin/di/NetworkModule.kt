package com.bakanito.developedwithkotlin.di

import com.bakanito.developedwithkotlin.data.network.PokedexApiClient
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    @Singleton //Única creación de la instancia
    @Provides
    fun provideRetrofit() : Retrofit {
        return Retrofit.Builder()
            .baseUrl("https://pokeapi.co/api/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    @Singleton
    @Provides
    fun providePokedexApiClient(retrofit: Retrofit): PokedexApiClient {
        return retrofit.create(PokedexApiClient::class.java)
    }
}