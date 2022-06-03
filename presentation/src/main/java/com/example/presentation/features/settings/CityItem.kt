package com.example.presentation.features.settings

sealed class CityItem(val id: String, val type: ViewType) {

    enum class ViewType { POSITION }

    data class PositionItem(
        val keyId: Int,
        val name: String,
        val isSelected: Boolean
    ) : CityItem("$keyId", ViewType.POSITION)
}