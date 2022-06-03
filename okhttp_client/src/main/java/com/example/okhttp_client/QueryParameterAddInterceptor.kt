package com.example.okhttp_client

import okhttp3.HttpUrl
import okhttp3.Interceptor
import okhttp3.Request
import okhttp3.Response

class QueryParameterAddInterceptor : Interceptor {

    override fun intercept(chain: Interceptor.Chain): Response {
        return run {
            val original: Request = chain.request()
            val originalHttpUrl: HttpUrl = original.url.newBuilder()
                .addQueryParameter("apikey", API_KEY)
                .build()

            val request = chain.request().newBuilder()
                .url(originalHttpUrl)
                .build()
            chain.proceed(request)
        }
    }

    companion object {
        const val API_KEY = "2tAzjR2YrsATgXEllP41Y7kJksb3WWui"
    }
}