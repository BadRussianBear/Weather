package com.example.presentation.features.weatherDetails

import androidx.lifecycle.viewModelScope
import com.example.domain.SharedPrefsManager
import com.example.domain.features.weather.WeatherDataLocal
import com.example.domain.features.weather.WeatherListInteractor
import com.example.presentation.R
import com.example.presentation.base.BaseViewModel
import com.example.presentation.features.weatherList.WeatherListNavigation
import javax.inject.Inject
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.launch

class WeatherDetailsViewModel @Inject constructor(
    private val weatherListInteractor: WeatherListInteractor,
    private val weatherDetailsMapper: WeatherDetailsMapper,
    private val prefsManager: SharedPrefsManager
) : BaseViewModel() {

    private val eventChannel = Channel<WeatherListNavigation>(Channel.BUFFERED)
    val eventsFlow = eventChannel.receiveAsFlow()

    private val _weatherState = MutableStateFlow<LatestDetailsUiState>(LatestDetailsUiState.Loading)
    val weatherUIState: StateFlow<LatestDetailsUiState> = _weatherState

    fun getDetails(weatherKey: Long) = launchIo(viewModelScope) {
        _weatherState.value = LatestDetailsUiState.Loading
        val result = weatherListInteractor.getWeatherFromDb(weatherKey)
        _weatherState.value = LatestDetailsUiState.Success(fillWeather(result))
    }

    private fun fillWeather(dataLocal: WeatherDataLocal): WeatherLocalItem {
        val curValue = prefsManager.getBoolean(
            R.string.pref_unit,
            resourceManager.getBoolean(R.bool.is_celsius)
        )

        return weatherDetailsMapper.mapToView(Pair(dataLocal, curValue))
    }

    fun settingsClicked() = launch(viewModelScope) {
        eventChannel.send(WeatherListNavigation.OpenSettings)
    }
}

sealed class LatestDetailsUiState {
    data class Success(val info: WeatherLocalItem): LatestDetailsUiState()
    object Loading : LatestDetailsUiState()
}
