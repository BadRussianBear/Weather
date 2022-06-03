import libraries.Android

object PresentationModuleLibraries : Library() {

    override val implementationDependencies = listOf(
        Android.androidXCore,
        Android.lifecycle,
        Android.lifecycleRuntime
    )

    override val apiDependencies: List<String> = listOf(
        Android.material
    )
}