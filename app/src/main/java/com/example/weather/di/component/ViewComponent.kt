package com.example.weather.di.component

import android.content.Context
import com.example.weather.MainActivity
import com.example.weather.features.weather.WeatherListFragment
import com.example.weather.base.BaseActivity
import com.example.weather.base.BaseFragment
import com.example.weather.di.module.ViewModelModule
import com.example.weather.di.module.navigation.LocalNavigationModule
import com.example.weather.di.module.navigation.NavigationModule
import com.example.weather.features.settings.SettingsFragment
import com.example.weather.features.weather.WeatherDetailsFragment
import dagger.BindsInstance
import dagger.Subcomponent

@Subcomponent(modules = [ViewModelModule::class, NavigationModule::class,
    LocalNavigationModule::class])
interface ViewComponent {

    fun inject(injectee: MainActivity)
    fun inject(injectee: BaseActivity)
    fun inject(injectee: BaseFragment)
    fun inject(injectee: WeatherListFragment)
    fun inject(injectee: WeatherDetailsFragment)
    fun inject(injectee: SettingsFragment)

    @Subcomponent.Builder
    interface Builder {

        @BindsInstance
        fun context(activityContext: Context): Builder
        fun build(): ViewComponent
    }
}