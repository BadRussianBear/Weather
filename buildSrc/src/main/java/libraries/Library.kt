abstract class Library {
    abstract val implementationDependencies: List<String>
    open val annotationProcessorDependencies: List<String> = emptyList()
    open val apiDependencies: List<String> = emptyList()
    open val kaptDependencies: List<String> = emptyList()
    open val coreDesugaringLibraryDependencies: List<String> = emptyList()
}