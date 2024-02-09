package com.example.retrofitmarvel.data.domain.model.hero

import com.example.retrofitmarvel.data.domain.model.BaseModel
import kotlinx.parcelize.Parcelize

@Parcelize
data class HeroModel(val name: String = "", val description: String) : BaseModel()