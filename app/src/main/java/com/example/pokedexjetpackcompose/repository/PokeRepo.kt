package com.example.pokedexjetpackcompose.repository

import com.example.pokedexjetpackcompose.data.remote.PokeApi
import com.example.pokedexjetpackcompose.data.remote.responses.Pokemon
import com.example.pokedexjetpackcompose.data.remote.responses.PokemonList
import com.example.pokedexjetpackcompose.util.Resource
import dagger.hilt.android.scopes.ActivityScoped
import javax.inject.Inject

@ActivityScoped //live inside activity
class PokeRepo
@Inject constructor(
    private val pokeApi: PokeApi
) {

    suspend fun getPokemonList(limit:Int,offset:Int):Resource<PokemonList>{
        val response = try {
            pokeApi.getPokemonList(limit, offset)
        }catch (e:Exception){
            return Resource.Error("An unknown error occurred")

        }
        return Resource.Success(response)
    }

    suspend fun getPokemonInfo(name:String):Resource<Pokemon>{
        val response = try {
            pokeApi.getPokemonInfo(name)
        }catch (e:Exception){
            return Resource.Error("An unknown error occurred")

        }
        return Resource.Success(response)
    }

}