package libraries

import Library

object CommonLibraries : Library() {

    override val implementationDependencies: List<String> = listOf(
        Kotlin.kotlinStd,
        Kotlin.coroutines,
        Kotlin.coroutinesAndroid
    )

    override val annotationProcessorDependencies: List<String> = listOf(
        Dagger.daggerCompiler
    )

    override val apiDependencies: List<String> = listOf(
        Dagger.daggerImpl,
        Kotlin.coroutines
    )

    override val kaptDependencies: List<String> = listOf(
        Dagger.daggerCompiler,
        Dagger.daggerAndroidProcessor
    )

    override val coreDesugaringLibraryDependencies: List<String> = listOf(
        Android.desugarJdkLibs
    )
}