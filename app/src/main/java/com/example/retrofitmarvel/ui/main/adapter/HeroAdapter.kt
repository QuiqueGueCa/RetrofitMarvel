package com.example.retrofitmarvel.ui.main.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.retrofitmarvel.R
import com.example.retrofitmarvel.data.domain.model.hero.HeroModel
import com.example.retrofitmarvel.databinding.ItemHeroBinding

class HeroAdapter(private val dataSet: MutableList<HeroModel>) :
    RecyclerView.Adapter<HeroAdapter.ViewHolder>() {


    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val binding = ItemHeroBinding.bind(view)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_hero, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.binding.tvNameHero.text = dataSet[position].name
    }

    override fun getItemCount(): Int = dataSet.size

    fun refreshData(heroes: MutableList<HeroModel>) {
        dataSet.clear()
        dataSet.addAll(heroes)
        notifyDataSetChanged()
    }
}
