package com.example.weather.features.weather

import androidx.appcompat.content.res.AppCompatResources
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.example.presentation.features.weatherList.WeatherItem
import com.example.weather.databinding.ItemWeatherBinding
import java.time.format.DateTimeFormatter

class WeatherViewHolder(private val binding: ItemWeatherBinding) : RecyclerView.ViewHolder(binding.root) {

    fun bind(item: WeatherItem.Weather, onClick: (WeatherItem.Weather) -> Unit) = with(binding) {
        val fmt: DateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd")
        weatherArticle.setOnClickListener { onClick(item) }
        date.text = fmt.format(item.date)
        max.text = item.tMax.toString()
        min.text = item.tMin.toString()
        dayIcon.setImageDrawable(ContextCompat.getDrawable(itemView.context, item.dayIcon))
        nightIcon.setImageDrawable(ContextCompat.getDrawable(itemView.context, item.nightIcon))
    }
}