package com.bakanito.developedwithkotlin.di

import android.content.Context
import androidx.room.Room
import com.bakanito.developedwithkotlin.data.database.PokedexDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

private const val POKEDEX_DATABASE_NAME = "pokedex_database"

@Module
@InstallIn(SingletonComponent::class)
class RoomModule {

    @Singleton
    @Provides
    fun provideRoom(@ApplicationContext context: Context) =
        Room.databaseBuilder(context, PokedexDatabase::class.java, POKEDEX_DATABASE_NAME).build()

    @Singleton
    @Provides
    fun providePokedexDao(db: PokedexDatabase) = db.getPokedexDao()

    @Singleton
    @Provides
    fun providePokemonDao(db: PokedexDatabase) = db.getPokemonDao()
}