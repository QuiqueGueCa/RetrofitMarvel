package com.example.retrofitmarvel.ui.main

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.retrofitmarvel.databinding.ActivityMainBinding
import com.example.retrofitmarvel.ui.main.adapter.HeroAdapter

class MainActivity : AppCompatActivity() {

    private lateinit var mBinding: ActivityMainBinding
    private lateinit var mAdapter: HeroAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        mBinding = ActivityMainBinding.inflate(layoutInflater)

        setContentView(mBinding.root)

        setupAdapter()

    }



    private fun setupAdapter() {
        mAdapter = HeroAdapter(arrayListOf())
        val listLayout = LinearLayoutManager(this)

        mBinding.recyclerView.setHasFixedSize(true)
        mBinding.recyclerView.layoutManager = listLayout
        mBinding.recyclerView.adapter = mAdapter
    }
}