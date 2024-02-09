package com.example.retrofitmarvel.ui.main

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.retrofitmarvel.data.domain.usecase.GetMarvelUseCase
import com.example.retrofitmarvel.databinding.ActivityMainBinding
import com.example.retrofitmarvel.injection.InjectionSingleton
import com.example.retrofitmarvel.ui.main.adapter.HeroAdapter
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {

    private lateinit var mBinding: ActivityMainBinding
    private lateinit var mAdapter: HeroAdapter
    private val mViewModel: MainViewModel =
        MainViewModel(GetMarvelUseCase(InjectionSingleton.provideDataSource()))
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        mBinding = ActivityMainBinding.inflate(layoutInflater)

        setContentView(mBinding.root)

        setupAdapter()

        setupViewModel()
        mViewModel.getHeroes()

    }

    private fun setupViewModel() {
        lifecycleScope.launch {
            mViewModel.heroes.collect {
                mAdapter.refreshData(it)
            }
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