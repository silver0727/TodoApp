plugins {
    id("com.android.library")
    kotlin("android")
    kotlin("kapt")
    id ("dagger.hilt.android.plugin")
}

apply(from = "../android.gradle")

dependencies {
    implementation(project(":domain"))

    // Hilt
    implementation(Libraries.Hilt.android)
    kapt(Libraries.Hilt.compiler)

    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.3")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.4.0")
}