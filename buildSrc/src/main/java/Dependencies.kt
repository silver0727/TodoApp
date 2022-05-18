object AppConfig {
    const val applicationId = "com.yeshin.todoapp"
    const val compileSDK = 32
    const val minSDK = 23
    const val targetSDK = 32
    const val versionCode = 1
    const val versionName = "1.0.0"
}

object Versions {
    const val gradle = "7.1.3"
    const val kotlin = "1.6.21"
    const val androidx_core = "1.7.0"
    const val androidx_appcompat = "1.4.1"
    const val material = "1.6.0"
    const val constraintlayout = "2.1.3"
    const val hilt = "2.28-alpha"
}

object Libraries {
    const val androidx_core_ktx = "androidx.core:core-ktx:${Versions.androidx_core}"
    const val androidx_appcompat = "androidx.appcompat:appcompat:${Versions.androidx_appcompat}"
    const val androidx_constaintlayout = "androidx.constraintlayout:constraintlayout:${Versions.constraintlayout}"
    const val google_material = "com.google.android.material:material:${Versions.material}"

    object Hilt {
        val android by lazy { "com.google.dagger:hilt-android:${Versions.hilt}" }
        val compiler by lazy { "com.google.dagger:hilt-android-compiler:${Versions.hilt}" }
    }
}

object BuildPlugins {
    val dagger_hilt_plugin by lazy { "com.google.dagger:hilt-android-gradle-plugin:${Versions.hilt}" }
}