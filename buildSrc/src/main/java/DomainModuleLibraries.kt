import libraries.Android
import libraries.Dagger
import libraries.Kotlin
import libraries.Utilities

object DomainModuleLibraries : Library() {

    override val implementationDependencies = listOf(
        Kotlin.kotlinStd,
        Utilities.gson
    )

    override val annotationProcessorDependencies: List<String> = listOf(
        Dagger.daggerCompiler
    )

    override val apiDependencies: List<String> = listOf(
        Kotlin.coroutines,
        Dagger.daggerImpl,
        Android.lifecycle,
        Android.lifecycleRuntime,
        Android.androidXCore
    )
}