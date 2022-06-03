import libraries.Database
import libraries.Network
import libraries.Utilities

object DataModuleLibraries : Library() {

    override val implementationDependencies = listOf(
        Network.retrofit,
        Utilities.gson,
        Utilities.gsonConverterFactory,
        Network.okHttpcookieStore,
        Network.cookieStore,
        Database.roomRuntime,
        Database.roomKtx
    )

    override val kaptDependencies = listOf(
        Database.roomCompiler
    )

    override val annotationProcessorDependencies = listOf(
        Database.roomKtx
    )

}