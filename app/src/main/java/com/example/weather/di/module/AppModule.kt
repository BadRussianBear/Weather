package com.example.weather.di.module

import android.content.Context
import androidx.fragment.app.FragmentActivity
import com.example.domain.di.AppContext
import com.example.weather.BuildConfig
import com.example.weather.WeatherApplication
import dagger.Module
import dagger.Provides
import javax.inject.Named
import javax.inject.Singleton

@Module
class AppModule {
    @Provides
    @Singleton
    @AppContext
    fun providesApplicationContext(application: WeatherApplication): Context = application

    @Named("APP_ID")
    @Provides
    @Singleton
    fun provideAppId(): String = BuildConfig.APPLICATION_ID
}