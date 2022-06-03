package com.example.weather

import android.app.Application
import com.example.weather.di.component.AppComponent
import com.example.weather.di.component.DaggerAppComponent
import com.example.weather.di.component.DataComponent
import javax.inject.Inject

class WeatherApplication @Inject constructor() : Application() {

    private lateinit var appComponent: AppComponent
    var dataComponent: DataComponent? = null
        get() {
            if (field == null) {
                dataComponent = appComponent.getDataComponentBuilder().build()
            }
            return field
        }

    override fun onCreate() {
        super.onCreate()
        appComponent = DaggerAppComponent
            .builder()
            .application(this)
            .build()
        appComponent.inject(this)
        dataComponent = appComponent.getDataComponentBuilder().build()
    }
}