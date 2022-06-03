package com.example.weather.features.settings

import androidx.core.view.isVisible
import androidx.recyclerview.widget.RecyclerView
import com.example.presentation.features.settings.CityItem
import com.example.weather.databinding.ItemCityBinding
import java.time.format.DateTimeFormatter

class CityViewHolder(private val binding: ItemCityBinding) : RecyclerView.ViewHolder(binding.root) {

    fun bind(item: CityItem.PositionItem, onClick: (CityItem.PositionItem) -> Unit) = with(binding) {
        article.setOnClickListener { onClick(item) }
        tvName.text = item.name
        ivSelect.isVisible = item.isSelected
    }
}