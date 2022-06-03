package com.example.weather.di.component

import com.example.weather.di.UserScope
import com.example.weather.di.userDataModule.MainDataModule
import com.example.weather.di.userDataModule.SettingsDataModule
import com.example.weather.di.userDataModule.WeatherListDataModule
import dagger.Subcomponent

@UserScope
@Subcomponent(modules = [WeatherListDataModule::class, SettingsDataModule::class, MainDataModule::class])
interface DataComponent {

    @Subcomponent.Builder
    interface Builder {

        fun build(): DataComponent
    }

    fun getViewComponentBuilder(): ViewComponent.Builder
}