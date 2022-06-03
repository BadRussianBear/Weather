package com.example.data.features.main

import java.net.URL

interface CityListUrlProvider {
    fun provideCityListAPI(): URL
}