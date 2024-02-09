package com.example.retrofitmarvel.ui.main

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.retrofitmarvel.data.domain.model.hero.HeroModel
import com.example.retrofitmarvel.data.domain.usecase.GetMarvelUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class MainViewModel(private val getMarvelUseCase: GetMarvelUseCase) : ViewModel() {

    private val _heroes = MutableStateFlow<MutableList<HeroModel>>(mutableListOf())
    val heroes: StateFlow<MutableList<HeroModel>> = _heroes

    fun getHeroes() {
        viewModelScope.launch(Dispatchers.IO) {
            getMarvelUseCase().collect {
                val heroesList = mutableListOf<HeroModel>()
                heroesList.addAll(it.heroListModel.results)
                _heroes.value = heroesList
            }
        }
    }

}