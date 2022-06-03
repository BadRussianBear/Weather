package libraries

object Dagger {

    private object Versions {
        const val daggerVersion = "2.38"
        const val daggerAndroidProcessor = "2.38"
    }

    const val daggerImpl = "com.google.dagger:dagger:${Versions.daggerVersion}"
    const val daggerCompiler = "com.google.dagger:dagger-compiler:${Versions.daggerVersion}"
    const val daggerAndroidProcessor = "com.google.dagger:dagger-android-processor:${Versions.daggerAndroidProcessor}"

}