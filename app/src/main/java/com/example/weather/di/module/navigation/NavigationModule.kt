package com.example.weather.di.module.navigation

import com.github.terrakok.cicerone.Cicerone
import com.github.terrakok.cicerone.Router
import com.github.terrakok.cicerone.Cicerone.Companion.create
import com.github.terrakok.cicerone.NavigatorHolder
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
object NavigationModule {
    private val cicerone: Cicerone<Router> = create()

    @Provides
    fun provideRouter(): Router {
        return cicerone.router
    }

    @Provides
    fun provideNavigatorHolder(): NavigatorHolder {
        return cicerone.getNavigatorHolder()
    }
}