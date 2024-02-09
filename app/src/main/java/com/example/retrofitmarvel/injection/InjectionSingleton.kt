package com.example.retrofitmarvel.injection

import com.example.retrofitmarvel.data.domain.repository.remote.RemoteApiService
import com.example.retrofitmarvel.data.domain.repository.remote.RetrofitClient

class InjectionSingleton {
    companion object {
        private fun provideApiServices(): RemoteApiService {
            return RetrofitClient.getInstance().getApiServices()
        }

    }
}