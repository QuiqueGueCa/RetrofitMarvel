package com.example.retrofitmarvel.data.domain.model.hero

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class MarvelModel(
    val heroesListModel: HeroesListModel
) : Parcelable