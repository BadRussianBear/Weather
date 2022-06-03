package libraries

object Kotlin {

    private object Versions {
        const val kotlinVersion = "1.4.20"
        const val ktxCore = "1.3.1"
        const val coroutinesVersion = "1.5.1"
    }

    const val kotlinStd = "org.jetbrains.kotlin:kotlin-stdlib:${Versions.kotlinVersion}"
    const val kotlinGradlePlugin = "org.jetbrains.kotlin:kotlin-gradle-plugin:${Versions.kotlinVersion}"
    const val ktxCore = "androidx.core:core-ktx:${Versions.ktxCore}"
    const val coroutines = "org.jetbrains.kotlinx:kotlinx-coroutines-core:${Versions.coroutinesVersion}"
    const val coroutinesAndroid = "org.jetbrains.kotlinx:kotlinx-coroutines-android:${Versions.coroutinesVersion}"
}