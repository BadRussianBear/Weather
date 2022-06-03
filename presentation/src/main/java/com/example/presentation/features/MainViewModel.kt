package com.example.presentation.features

import androidx.lifecycle.viewModelScope
import com.example.domain.SharedPrefsManager
import com.example.domain.base.Outcome
import com.example.domain.features.main.CityListInteractor
import com.example.domain.features.settings.SettingsInteractor
import com.example.presentation.R
import com.example.presentation.base.BaseViewModel
import com.example.presentation.features.weatherList.LatestWeatherUiState
import com.example.presentation.features.weatherList.WeatherItem
import javax.inject.Inject
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class MainViewModel @Inject constructor(
    private val prefsManager: SharedPrefsManager,
    private val settingsInteractor: SettingsInteractor,
    private val cityListInteractor: CityListInteractor
) : BaseViewModel() {

    private val _mainState = MutableStateFlow<LatestMainUiState>(LatestMainUiState.Loading)
    val mainUIState: StateFlow<LatestMainUiState> = _mainState

    fun startInit() = launchIo(viewModelScope) {
        if(settingsInteractor.getCityList().isNullOrEmpty()) {
            _mainState.value = LatestMainUiState.Loading
            prefsManager.saveBoolean(R.string.pref_unit, resourceManager.getBoolean(R.bool.is_celsius))
            when(val result = cityListInteractor.geCityList()) {
                is Outcome.Success -> {
                    _mainState.value = LatestMainUiState.Success
                }
                is Outcome.Error -> {
                    _mainState.value = LatestMainUiState.Error(result.reason)
                }
            }
        }
        else _mainState.value = LatestMainUiState.Success
    }

}

sealed class LatestMainUiState {
    object Success: LatestMainUiState()
    data class Error(val message: String) : LatestMainUiState()
    object Loading : LatestMainUiState()
}