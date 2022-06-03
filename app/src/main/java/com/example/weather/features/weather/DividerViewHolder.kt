package com.example.weather.features.weather

import androidx.recyclerview.widget.RecyclerView
import com.example.presentation.features.weatherList.WeatherItem
import com.example.weather.databinding.ItemDividerBinding

class DividerViewHolder(private val binding: ItemDividerBinding) : RecyclerView.ViewHolder(binding.root) {

    fun bind(item: WeatherItem.Divider) = with(binding) {

    }
}