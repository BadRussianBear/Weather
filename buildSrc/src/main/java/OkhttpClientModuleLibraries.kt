import libraries.Kotlin
import libraries.Network

object OkhttpClientModuleLibraries : Library() {

    override val implementationDependencies =
        listOf(
            Kotlin.kotlinStd,
            Kotlin.coroutines,
            Kotlin.coroutinesAndroid,
            Network.okHttp,
            Network.cookieStore,
            Network.okHttpcookieStore,
            Network.stetho,
            Network.stethoOkhttp,
            Network.loggingInterceptor
        )
}