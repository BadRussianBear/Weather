package com.example.weather.extensions

import android.content.Intent
import android.net.Uri
import com.example.weather.features.settings.SettingsFragment
import com.example.weather.features.weather.WeatherDetailsFragment
import com.example.weather.features.weather.WeatherListFragment
import com.github.terrakok.cicerone.androidx.ActivityScreen
import com.github.terrakok.cicerone.androidx.FragmentScreen

object Screens {

    fun WeatherList() = FragmentScreen {
        WeatherListFragment()
    }

    fun WeatherDetails(id: Long) = FragmentScreen {
        WeatherDetailsFragment.getNewInstance(id)
    }

    fun Settings() = FragmentScreen {
        SettingsFragment()
    }

    fun Github() = ActivityScreen {
        Intent(Intent.ACTION_VIEW, Uri.parse("https://www.youtube.com/watch?v=dQw4w9WgXcQ"))
    }

}