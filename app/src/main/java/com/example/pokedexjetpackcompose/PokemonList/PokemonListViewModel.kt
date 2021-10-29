package com.example.pokedexjetpackcompose.PokemonList

import android.graphics.Bitmap
import android.graphics.drawable.AdaptiveIconDrawable
import android.graphics.drawable.BitmapDrawable
import android.graphics.drawable.Drawable
import androidx.compose.ui.graphics.Color
import androidx.lifecycle.ViewModel
import androidx.palette.graphics.Palette
import com.example.pokedexjetpackcompose.repository.PokeRepo
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class PokemonListViewModel @Inject constructor(
    private val repo : PokeRepo
) : ViewModel() {

    fun calcDominantColor(drawable: Drawable, onFinish : (Color) -> Unit){
        val bmp = (drawable as BitmapDrawable).bitmap.copy(
            Bitmap.Config.ARGB_8888,true
        )
        Palette.from(bmp).generate{
            it?.dominantSwatch?.rgb?.let{color->
                onFinish(Color(color))
            }
        }
    }

}