package com.example.weather.di.component

import com.example.weather.WeatherApplication
import com.example.weather.di.module.AppModule
import com.example.weather.di.module.DataModule
import com.example.weather.di.module.NetworkModule
import com.example.weather.di.module.UtilityModule
import com.example.weather.di.module.ViewModelFactoryModule
import com.example.weather.di.module.navigation.LocalNavigationModule
import com.example.weather.di.module.navigation.NavigationModule
import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton

@Component(
    modules = [
        DataModule::class,
        AppModule::class,
        UtilityModule::class,
        NetworkModule::class,
        ViewModelFactoryModule::class
    ]
)
@Singleton
interface AppComponent {

    fun getDataComponentBuilder(): DataComponent.Builder

    @Component.Builder
    interface Builder {

        @BindsInstance
        fun application(application:WeatherApplication): Builder
        fun build(): AppComponent
    }

    fun inject(application: WeatherApplication)
}