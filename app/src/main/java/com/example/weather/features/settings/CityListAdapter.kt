package com.example.weather.features.settings

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.presentation.features.settings.CityItem
import com.example.weather.databinding.ItemCityBinding

class CityListAdapter(
    private val articleOnClick: (CityItem.PositionItem) -> Unit
) : ListAdapter<CityItem, RecyclerView.ViewHolder>(CityItemDiffUtil()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return CityViewHolder(ItemCityBinding.inflate(inflater, parent, false))
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when (holder) {
            is CityViewHolder -> holder.bind(getItem(position) as CityItem.PositionItem, articleOnClick)
        }
    }
}

@SuppressLint("DiffUtilEquals")
class CityItemDiffUtil : DiffUtil.ItemCallback<CityItem>() {
    override fun areItemsTheSame(oldItem: CityItem, newItem: CityItem): Boolean = oldItem.id == newItem.id
    override fun areContentsTheSame(oldItem: CityItem, newItem: CityItem): Boolean = oldItem == newItem
}