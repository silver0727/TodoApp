plugins {
    id("com.android.library")
    kotlin("android")
    kotlin("kapt")
    id ("dagger.hilt.android.plugin")
    id ("androidx.navigation.safeargs.kotlin")
}

apply(from = "../android.gradle")

android {
    buildTypes {
        debug {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
}

dependencies {
    implementation(project(":domain"))

    Libraries.Debugging.apply {
        implementation(timber)
    }

    Libraries.AndroidX.apply {
        implementation(core_ktx)
        implementation(appcompat)
        implementation(constaintlayout)
        implementation(fragment_ktx)
        implementation(navigation_fragment_ktx)
        implementation(navigation_ui_ktx)
    }

    implementation(Libraries.google_material)

    Libraries.Lifecycle.apply {
        implementation(runtime)
        implementation(process)
        implementation(viewModel_ktx)
        implementation(livedata_ktx)
    }

    // Hilt
    implementation(Libraries.Hilt.android)
    kapt(Libraries.Hilt.compiler)

//    implementation(Libraries.viewModel)

    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.3")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.4.0")
}