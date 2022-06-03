package libraries

object Database {

    private object Versions {
        const val roomVersion = "2.2.0"
    }

    const val roomKtx = "androidx.room:room-ktx:${Versions.roomVersion}" //imp
    const val roomRuntime = "androidx.room:room-runtime:${Versions.roomVersion}" //imp
    const val roomCompiler = "androidx.room:room-compiler:${Versions.roomVersion}" //kapt
}