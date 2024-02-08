package com.example.retrofitmarvel.data.domain.model.hero

import com.example.retrofitmarvel.data.domain.model.BaseModel

data class HeroesListModel(
    val results: List<HeroModel> = arrayListOf()
) : BaseModel()