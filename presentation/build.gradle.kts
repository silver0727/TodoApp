plugins {
    id("com.android.library")
    kotlin("android")
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

    implementation(Libraries.androidx_core_ktx)
    implementation(Libraries.androidx_appcompat)
    implementation(Libraries.androidx_constaintlayout)
    implementation(Libraries.google_material)

    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.3")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.4.0")
}