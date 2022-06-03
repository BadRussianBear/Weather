package com.example.okhttp_client

import net.gotev.cookiestore.WebKitSyncCookieManager
import net.gotev.cookiestore.okhttp.JavaNetCookieJar
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor

object OkHttpClientProvider {

    fun createOkHttpClient(
        cookieManager: WebKitSyncCookieManager
    ): OkHttpClient {
        val okHttpBuilder = OkHttpClient.Builder()
            .cookieJar(JavaNetCookieJar(cookieManager))
            .addInterceptor(QueryParameterAddInterceptor())

        return okHttpBuilder.build()
    }
}