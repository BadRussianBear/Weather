package com.example.presentation.features.weatherList

import androidx.lifecycle.viewModelScope
import com.example.domain.SharedPrefsManager
import com.example.domain.base.Outcome
import com.example.domain.features.settings.SettingsInteractor
import com.example.domain.features.weather.WeatherDataRemote
import com.example.domain.features.weather.WeatherListInteractor
import com.example.presentation.R
import com.example.presentation.base.BaseViewModel
import javax.inject.Inject
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.launch

class WeatherListViewModel @Inject constructor(
    private val weatherListInteractor: WeatherListInteractor,
    private val settingsInteractor: SettingsInteractor,
    private val weatherListMapper: WeatherListMapper,
    private val prefsManager: SharedPrefsManager
) : BaseViewModel() {

    private val eventChannel = Channel<WeatherListNavigation>(Channel.BUFFERED)
    val eventsFlow = eventChannel.receiveAsFlow()

    private val cityChannel = Channel<String>(Channel.BUFFERED)
    val cityFlow = cityChannel.receiveAsFlow()

    //I think it's better to use Channel with receiveAsFlow but I want to see StateFlow
    private val _weatherState = MutableStateFlow<LatestWeatherUiState>(LatestWeatherUiState.Loading)
    val weatherUIState: StateFlow<LatestWeatherUiState> = _weatherState

    fun getCity() = launchIo(viewModelScope) {
        cityChannel.send(settingsInteractor.getCityFromDb().name)
    }

    fun getList() = launch(viewModelScope) {
        _weatherState.value = LatestWeatherUiState.Loading
        when (val result = weatherListInteractor.getWeatherList()) {
            is Outcome.Success -> {
                _weatherState.value = LatestWeatherUiState.Success(fillWeather(result.data))
            }
            is Outcome.Error -> {
                _weatherState.value = LatestWeatherUiState.Error(result.reason)
            }
        }
    }

    private fun fillWeather(dataRemote: WeatherDataRemote): List<WeatherItem> {
        val curValue = prefsManager.getBoolean(R.string.pref_unit, resourceManager.getBoolean(R.bool.is_celsius))

        val result = dataRemote.weatherList.map { weather ->
            weatherListMapper.mapToView(Pair(weather, curValue))
        }
        val newResult = mutableListOf<WeatherItem>()
        result.forEachIndexed { index, weather ->
            newResult.add(weather)
            if (index != result.size - 1) {
                newResult.add(WeatherItem.Divider)
            }
        }
        return newResult
    }

    fun dayClicked(item: WeatherItem.Weather?) = launch(viewModelScope) {
        item?.let {
            eventChannel.send(WeatherListNavigation.OpenDetailView(item.dateEpoch))
        }
    }

    fun settingsClicked() = launch(viewModelScope) {
        eventChannel.send(WeatherListNavigation.OpenSettings)
    }
}

sealed class LatestWeatherUiState {
    data class Success(val info: List<WeatherItem>): LatestWeatherUiState()
    data class Error(val message: String) : LatestWeatherUiState()
    object Loading : LatestWeatherUiState()
}
