package libraries

object Utilities {

    private object Versions {
        const val gsonVersion = "2.8.9"
        const val gsonConverterFactoryVersion = "2.9.0"
    }

    const val gson = "com.google.code.gson:gson:${Versions.gsonVersion}"
    const val gsonConverterFactory = "com.squareup.retrofit2:converter-gson:${Versions.gsonConverterFactoryVersion}"
}