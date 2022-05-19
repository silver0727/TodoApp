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
    // UI
    const val core_ktx = "1.7.0"
    const val appcompat = "1.4.1"
    const val constraintlayout = "2.1.3"
    const val navigation = "2.4.2"
    const val material = "1.6.0"
    // DI
    const val hilt = "2.28-alpha"
    const val viewmodel_ktx = "2.4.1"
}

object Libraries {
    const val google_material = "com.google.android.material:material:${Versions.material}"

    val viewModel by lazy { "androidx.lifecycle:lifecycle-viewmodel:${Versions.viewmodel_ktx}" }

    object AndroidX {
        val core_ktx by lazy { "androidx.core:core-ktx:${Versions.core_ktx}" }
        val appcompat by lazy { "androidx.appcompat:appcompat:${Versions.appcompat}" }
        val constaintlayout by lazy { "androidx.constraintlayout:constraintlayout:${Versions.constraintlayout}" }
        val navigation_fragment_ktx by lazy { "androidx.navigation:navigation-fragment-ktx:${Versions.navigation}" }
        val navigation_ui_ktx by lazy { "androidx.navigation:navigation-ui-ktx:${Versions.navigation}" }
    }

    object Hilt {
        val android by lazy { "com.google.dagger:hilt-android:${Versions.hilt}" }
        val compiler by lazy { "com.google.dagger:hilt-android-compiler:${Versions.hilt}" }
    }
}

object BuildPlugins {
    val dagger_hilt_plugin by lazy { "com.google.dagger:hilt-android-gradle-plugin:${Versions.hilt}" }
    val navigation_plugin by lazy { "androidx.navigation:navigation-safe-args-gradle-plugin:${Versions.navigation}" }
}