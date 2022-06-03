package com.example.weather.di.module

import android.content.Context
import com.example.data.RestApi
import com.example.data.features.main.CityListUrlProvider
import com.example.data.features.weather.WeatherListUrlProvider
import com.example.domain.di.AppContext
import com.example.okhttp_client.OkHttpClientProvider
import com.example.weather.BuildConfig
import com.example.weather.urlProvider.SettingsListUrlProviderImpl
import com.example.weather.urlProvider.WeatherListUrlProviderImpl
import dagger.Module
import dagger.Provides
import java.net.CookiePolicy
import javax.inject.Singleton
import net.gotev.cookiestore.SharedPreferencesCookieStore
import net.gotev.cookiestore.WebKitSyncCookieManager
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

@Module
object NetworkModule {

    @Provides
    @Singleton
    @JvmStatic
    fun provideRetrofit(okHttpClient: OkHttpClient): Retrofit {
        return Retrofit.Builder()
            .client(okHttpClient)
            .baseUrl(BuildConfig.SOME_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    @Provides
    @Singleton
    @JvmStatic
    fun provideOkHttpClient(
        cookieManager: WebKitSyncCookieManager,
    ): OkHttpClient {
        return OkHttpClientProvider.createOkHttpClient(
            cookieManager = cookieManager
        )
    }

    @Provides
    @Singleton
    @JvmStatic
    fun provideUpstoxApi(retrofit: Retrofit): RestApi {
        return retrofit.create(RestApi::class.java)
    }

    @Provides
    @Singleton
    fun cookieManager(@AppContext appContext: Context) =
        WebKitSyncCookieManager(SharedPreferencesCookieStore(appContext, ""), CookiePolicy.ACCEPT_ALL)


    @Provides
    @Singleton
    fun provideWeatherListAPI(impl: WeatherListUrlProviderImpl): WeatherListUrlProvider {
        return impl
    }

    @Provides
    @Singleton
    fun provideCityListAPI(impl: SettingsListUrlProviderImpl): CityListUrlProvider {
        return impl
    }
}