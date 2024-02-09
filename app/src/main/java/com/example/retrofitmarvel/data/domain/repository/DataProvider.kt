package com.example.retrofitmarvel.data.domain.repository

import com.example.retrofitmarvel.data.domain.repository.remote.response.MarvelResponse
import kotlinx.coroutines.flow.Flow

class DataProvider(private val remoteDataSource: DataSource) : DataSource {

    companion object {
        var INSTANCE: DataProvider? = null

        @Synchronized
        fun getInstance(remoteDataSource: DataSource): DataProvider {
            if (INSTANCE == null) {
                INSTANCE = DataProvider(remoteDataSource)
            }
            return INSTANCE!!
        }
    }

    override fun getListHeroes(): Flow<MarvelResponse> {
        return remoteDataSource.getListHeroes()
    }
}