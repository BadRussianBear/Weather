package com.example.presentation.features.settings

import androidx.lifecycle.viewModelScope
import com.example.domain.SharedPrefsManager
import com.example.domain.features.settings.SettingsInteractor
import com.example.presentation.R
import com.example.presentation.base.BaseViewModel
import javax.inject.Inject
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class SettingsViewModel @Inject constructor(
    private val listInteractor: SettingsInteractor,
    private val cityListMapper: CityListMapper,
    private val prefsManager: SharedPrefsManager
) : BaseViewModel() {

    private val eventChannel = Channel<SettingsNavigation>(Channel.BUFFERED)
    val eventsFlow = eventChannel.receiveAsFlow()

    private val _cityState = MutableStateFlow<List<CityItem.PositionItem>>(listOf())
    val cityUIState = _cityState.asStateFlow()

    private val _unitState = MutableStateFlow<Boolean>(false)
    val unitUIState = _unitState.asStateFlow()

    fun getCityList() = launchIo(viewModelScope) {
        val result = cityListMapper.mapListToView(listInteractor.getCityList()).sortedBy { it.name }
        _cityState.value = result
    }

    fun getUnit() = launch(viewModelScope) {
        val curValue = prefsManager.getBoolean(R.string.pref_unit, resourceManager.getBoolean(R.bool.is_celsius))
        _unitState.update { curValue }
    }

    fun unitChanged() {
        val curValue = prefsManager.getBoolean(R.string.pref_unit, resourceManager.getBoolean(R.bool.is_celsius))
        prefsManager.saveBoolean(R.string.pref_unit, !curValue)
        _unitState.update { it.not() }
    }

    fun cityClicked(item: CityItem.PositionItem) = launchIo(viewModelScope) {
        listInteractor.changeSelectedCity(item.keyId)
        _cityState.update { list ->
            list.map { inner ->
                when {
                    inner.isSelected && item.keyId != inner.keyId -> { inner.copy(isSelected = false) }
                    item.keyId == inner.keyId -> inner.copy(isSelected = true)
                    else -> inner
                }
            }
        }
    }

    fun divinationClicked() = launch(viewModelScope) {
        eventChannel.send(SettingsNavigation.OpenWebPage)
    }

}