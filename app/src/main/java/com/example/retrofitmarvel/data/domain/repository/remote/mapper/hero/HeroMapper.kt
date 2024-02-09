package com.example.retrofitmarvel.data.domain.repository.remote.mapper.hero

import com.example.retrofitmarvel.data.domain.model.hero.HeroModel
import com.example.retrofitmarvel.data.domain.repository.remote.mapper.ResponseMapper
import com.example.retrofitmarvel.data.domain.repository.remote.response.HeroResponse

class HeroMapper : ResponseMapper<HeroResponse, HeroModel> {
    override fun fromResponse(response: HeroResponse): HeroModel {
        return HeroModel(response.name ?: "", response.description ?: "")
    }
}