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
    implementation(Libraries.AndroidX.core_ktx)
    implementation(Libraries.AndroidX.appcompat)
    implementation(Libraries.AndroidX.constaintlayout)
    implementation(Libraries.AndroidX.navigation_fragment_ktx)
    implementation(Libraries.AndroidX.navigation_ui_ktx)
    implementation(project(":domain"))

    implementation(Libraries.google_material)

    // Hilt
    implementation(Libraries.Hilt.android)
    kapt(Libraries.Hilt.compiler)

//    implementation(Libraries.viewModel)

    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.3")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.4.0")
}