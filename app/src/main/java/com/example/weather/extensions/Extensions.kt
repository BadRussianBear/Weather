package com.example.weather.extensions

import com.example.weather.WeatherApplication
import com.example.weather.base.BaseActivity
import com.example.weather.base.BaseFragment

fun BaseFragment.viewComponent() =
    (activity?.application as WeatherApplication).dataComponent!!.getViewComponentBuilder()
        .context(requireContext())
        .build()

fun BaseActivity.viewComponent() =
    (application as WeatherApplication).dataComponent!!.getViewComponentBuilder()
        .context(this)
        .build()