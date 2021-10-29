package com.example.pokedexjetpackcompose.di

import com.example.pokedexjetpackcompose.data.remote.PokeApi
import com.example.pokedexjetpackcompose.repository.PokeRepo
import com.google.gson.Gson
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class) //single instance app life scope
object AppModule {
    @Provides
    @Singleton
    fun providePokeRepo(api: PokeApi) = PokeRepo(api)

    @Provides
    @Singleton
    fun providePokeApi():PokeApi = Retrofit.Builder()
        .addConverterFactory(GsonConverterFactory.create())
        .baseUrl("https://pokeapi.co/api/v2/")
        .build()
        .create(PokeApi::class.java)



}