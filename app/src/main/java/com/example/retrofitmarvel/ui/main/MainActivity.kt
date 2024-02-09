package com.example.retrofitmarvel.ui.main

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.retrofitmarvel.data.domain.repository.DataProvider
import com.example.retrofitmarvel.data.domain.repository.remote.RemoteDataSource
import com.example.retrofitmarvel.data.domain.repository.remote.RetrofitClient
import com.example.retrofitmarvel.databinding.ActivityMainBinding
import com.example.retrofitmarvel.ui.main.adapter.HeroAdapter
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {

    private lateinit var mBinding: ActivityMainBinding
    private lateinit var mAdapter: HeroAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        mBinding = ActivityMainBinding.inflate(layoutInflater)

        setContentView(mBinding.root)

        setupAdapter()

        lifecycleScope.launch { getMarvel() }


    }

    private suspend fun getMarvel() {
        val remoteDataSource = DataProvider.getInstance(
            RemoteDataSource.getInstance(
                RetrofitClient.getInstance().getApiServices()
            )
        )

        val listMarvel = remoteDataSource.getListHeroes().collect {
            println("|||||||||||||||||||||||||||||||||||||||||||||||||||11")
            println(it)
        }
    }

    private fun setupAdapter() {
        mAdapter = HeroAdapter(arrayListOf())
        val listLayout = LinearLayoutManager(this)

        mBinding.recyclerView.setHasFixedSize(true)
        mBinding.recyclerView.layoutManager = listLayout
        mBinding.recyclerView.adapter = mAdapter
    }
}