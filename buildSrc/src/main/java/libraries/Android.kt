package libraries

object Android {

    private object Versions {

        const val constraintLayoutVersion = "2.0.4"
        const val lifecycleExtensionsVersion = "2.2.0"
        const val androidXCore = "1.3.2"
        const val androidXAnnotation = "1.2.0"
        const val material = "1.4.0"
        const val viewmodelKtx = "2.3.0-alpha01"
        const val viewmodelKtx1 = "2.2.0-alpha03"
        const val desugarJdkLibs = "1.1.5"
        const val recyclerView = "1.2.1"
        const val swipeRefresh = "1.1.0"
        const val cicerone = "7.1"
        const val activityVersion = "1.2.3"
        const val fragmentVersion = "1.3.2"
    }

    const val constraintLayout = "androidx.constraintlayout:constraintlayout:${Versions.constraintLayoutVersion}"
    const val androidXCore = "androidx.core:core-ktx:${Versions.androidXCore}"
    const val material = "com.google.android.material:material:${Versions.material}"
    const val desugarJdkLibs = "com.android.tools:desugar_jdk_libs:${Versions.desugarJdkLibs}"
    const val recyclerView = "androidx.recyclerview:recyclerview:${Versions.recyclerView}"
    const val swiperefresh = "androidx.swiperefreshlayout:swiperefreshlayout:${Versions.swipeRefresh}"
    const val androidXAnnotation =  "androidx.annotation:annotation:${Versions.androidXAnnotation}"
    const val cicerone = "com.github.terrakok:cicerone:${Versions.cicerone}"
    const val activity = "androidx.activity:activity-ktx:${Versions.activityVersion}"
    const val fragment = "androidx.fragment:fragment-ktx:${Versions.fragmentVersion}"
    const val lifecycle = "androidx.lifecycle:lifecycle-viewmodel-ktx:${Versions.viewmodelKtx}"
    const val lifecycleRuntime = "androidx.lifecycle:lifecycle-runtime-ktx:${Versions.viewmodelKtx1}"
    const val lifecycleExtensions = "androidx.lifecycle:lifecycle-extensions:${Versions.lifecycleExtensionsVersion}"
}