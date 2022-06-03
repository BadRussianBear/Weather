package com.example.weather.features.weather

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.presentation.features.weatherList.WeatherItem
import com.example.weather.databinding.ItemDividerBinding
import com.example.weather.databinding.ItemWeatherBinding

class WeatherListAdapter(
    private val articleOnClick: (WeatherItem.Weather) -> Unit
) : ListAdapter<WeatherItem, RecyclerView.ViewHolder>(WeatherItemDiffUtil()) {

    override fun getItemViewType(position: Int): Int = getItem(position).viewType.ordinal

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return when (WeatherItem.ViewType.values()[viewType]) {
            WeatherItem.ViewType.WEATHER -> WeatherViewHolder(ItemWeatherBinding.inflate(inflater, parent, false))
            WeatherItem.ViewType.DIVIDER -> DividerViewHolder(ItemDividerBinding.inflate(inflater, parent, false))
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when (holder) {
            is WeatherViewHolder -> holder.bind(getItem(position) as WeatherItem.Weather, articleOnClick)
            is DividerViewHolder -> holder.bind(getItem(position) as WeatherItem.Divider)
        }
    }
}

@SuppressLint("DiffUtilEquals")
class WeatherItemDiffUtil : DiffUtil.ItemCallback<WeatherItem>() {
    override fun areItemsTheSame(oldItem: WeatherItem, newItem: WeatherItem): Boolean = oldItem.id == newItem.id
    override fun areContentsTheSame(oldItem: WeatherItem, newItem: WeatherItem): Boolean = oldItem == newItem
}