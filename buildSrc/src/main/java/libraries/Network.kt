package libraries

import libraries.Network.Versions.cookieStoreVersion
import libraries.Network.Versions.stethoVersion

object Network {

    private object Versions {
        const val retrofitVersion = "2.9.0"
        const val loggingInterceptorVersion = "4.9.2"
        const val okHttpVersion = "4.9.1"
        const val stethoVersion = "1.6.0"
        const val cookieStoreVersion = "1.4.0"
    }

    const val retrofit = "com.squareup.retrofit2:retrofit:${Versions.retrofitVersion}"
    const val loggingInterceptor = "com.squareup.okhttp3:logging-interceptor:${Versions.loggingInterceptorVersion}"
    const val okHttp = "com.squareup.okhttp3:okhttp:${Versions.okHttpVersion}"
    const val stetho = "com.facebook.stetho:stetho:${stethoVersion}"
    const val stethoOkhttp = "com.facebook.stetho:stetho-okhttp3:${stethoVersion}"
    const val okHttpcookieStore = "net.gotev:cookie-store-okhttp:${cookieStoreVersion}"
    const val cookieStore = "net.gotev:cookie-store:${cookieStoreVersion}"
}