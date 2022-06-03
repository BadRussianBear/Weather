import libraries.Android
import libraries.Database
import libraries.Network
import libraries.Utilities

object AppModuleLibraries : Library() {

    override val implementationDependencies = listOf(
        Utilities.gson,
        Utilities.gsonConverterFactory,
        Android.constraintLayout,
        Android.lifecycleExtensions,
        Android.androidXCore,
        Android.recyclerView,
        Android.swiperefresh,
        Android.cicerone,
        Android.activity,
        Android.fragment,
        Android.lifecycleRuntime,
        Database.roomKtx,
        Network.retrofit,
        Network.loggingInterceptor,
        Network.okHttp,
        Network.cookieStore,
        Network.okHttpcookieStore
    )
}