package com.example.retrofitmarvel.data.domain.repository.remote

import com.example.retrofitmarvel.data.domain.repository.DataSource
import com.example.retrofitmarvel.data.domain.repository.remote.response.MarvelResponse
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class RemoteDataSource(private val remoteApiService: RemoteApiService) : DataSource {
    companion object {
        var INSTANCE: RemoteDataSource? = null

        @Synchronized
        fun getInstance(remoteApiService: RemoteApiService): RemoteDataSource {
            if (INSTANCE == null) {
                INSTANCE = RemoteDataSource(remoteApiService)
            }
            return INSTANCE!!
        }
    }

    override fun getListHeroes(): Flow<MarvelResponse> = flow {
        emit(
            remoteApiService.getMarvel().body()!!
        )
    }
}