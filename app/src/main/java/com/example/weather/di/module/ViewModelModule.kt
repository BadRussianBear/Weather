package com.example.weather.di.module

import `in`.upstox.pro.beta.app.di.annotation.ViewModelKey
import androidx.lifecycle.ViewModel
import com.example.presentation.features.MainViewModel
import com.example.presentation.features.settings.SettingsViewModel
import com.example.presentation.features.weatherDetails.WeatherDetailsViewModel
import com.example.presentation.features.weatherList.WeatherListViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class ViewModelModule {

    @Binds
    @IntoMap
    @ViewModelKey(MainViewModel::class)
    abstract fun bindMainViewModel(viewModel: MainViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(WeatherListViewModel::class)
    abstract fun bindWeatherListViewModel(viewModel: WeatherListViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(WeatherDetailsViewModel::class)
    abstract fun bindWeatherDetailsViewModel(viewModel: WeatherDetailsViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(SettingsViewModel::class)
    abstract fun bindSettingsViewModel(viewModel: SettingsViewModel): ViewModel

}
