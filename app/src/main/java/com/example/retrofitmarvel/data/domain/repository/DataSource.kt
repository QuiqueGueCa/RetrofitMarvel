package com.example.retrofitmarvel.data.domain.repository

import com.example.retrofitmarvel.data.domain.repository.remote.response.MarvelResponse
import kotlinx.coroutines.flow.Flow

interface DataSource {
    fun getListHeroes(): Flow<MarvelResponse>
}