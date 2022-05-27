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
    const val coroutine = "1.5.0"
    const val timber = "4.7.1"
    // DI
    const val hilt = "2.41"
    // Presentation
    const val core_ktx = "1.7.0"
    const val appcompat = "1.4.1"
    const val constraintlayout = "2.1.3"
    const val fragment = "1.4.1"
    const val navigation = "2.4.2"
    const val material = "1.6.0"
    const val archLifecycle = "2.4.1"
    // Data
    const val room = "2.4.2"
    // Domain
}

object Libraries {
    const val google_material = "com.google.android.material:material:${Versions.material}"

    object Lifecycle {
        val process by lazy { "androidx.lifecycle:lifecycle-viewmodel-ktx:${Versions.archLifecycle}" }
        val runtime by lazy { "androidx.lifecycle:lifecycle-runtime-ktx:2.4.0-alpha01" }
        val viewModel_ktx by lazy { "androidx.lifecycle:lifecycle-viewmodel-ktx:${Versions.archLifecycle}" }
        val livedata_ktx by lazy { "androidx.lifecycle:lifecycle-livedata-ktx:${Versions.archLifecycle}" }
        val compiler by lazy { "androidx.lifecycle:lifecycle-lifecycle-compiler:${Versions.archLifecycle}" }
    }

    object AndroidX {
        val core_ktx by lazy { "androidx.core:core-ktx:${Versions.core_ktx}" }
        val appcompat by lazy { "androidx.appcompat:appcompat:${Versions.appcompat}" }
        val constaintlayout by lazy { "androidx.constraintlayout:constraintlayout:${Versions.constraintlayout}" }
        val fragment_ktx by lazy { "androidx.fragment:fragment-ktx:${Versions.fragment}" }
        val navigation_fragment_ktx by lazy { "androidx.navigation:navigation-fragment-ktx:${Versions.navigation}" }
        val navigation_ui_ktx by lazy { "androidx.navigation:navigation-ui-ktx:${Versions.navigation}" }
    }

    object Hilt {
        val android by lazy { "com.google.dagger:hilt-android:${Versions.hilt}" }
        val compiler by lazy { "com.google.dagger:hilt-android-compiler:${Versions.hilt}" }
    }

    object Room {
        val runtime by lazy { "androidx.room:room-runtime:${Versions.room}" }
        val compiler by lazy { "androidx.room:room-compiler:${Versions.room}" }
        val ktx by lazy { "androidx.room:room-ktx:${Versions.room}" }
    }

    object Coroutine {
        val core by lazy { "org.jetbrains.kotlinx:kotlinx-coroutines-core-jvm:${Versions.coroutine}" }
    }

    object Debugging {
        val timber by lazy { "com.jakewharton.timber:timber:${Versions.timber}" }
        val flipper by lazy { "com.facebook.flipper:flipper:0.147.0" }
        val soloader by lazy { "com.facebook.soloader:soloader:0.10.1" }
        val flipperNetworkPlugin by lazy { "com.facebook.flipper:flipper-network-plugin:0.147.0" }
    }
}

object BuildPlugins {
    val dagger_hilt_plugin by lazy { "com.google.dagger:hilt-android-gradle-plugin:${Versions.hilt}" }
    val navigation_plugin by lazy { "androidx.navigation:navigation-safe-args-gradle-plugin:${Versions.navigation}" }
}