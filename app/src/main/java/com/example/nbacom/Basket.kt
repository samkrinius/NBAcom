package com.example.nbacom

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize

data class Basket(
    val title: String,
    val description: String,
    val pelatih: String,
    val pemilik: String,
    val releaseYear: String,
    val tags: String,
    val stadion: String,
    val gameLogo:Int
) : Parcelable
