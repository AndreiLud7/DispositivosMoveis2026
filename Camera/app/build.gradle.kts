plugins {
    alias(libs.plugins.android.application)
}

android {
    namespace = "com.example.camera"
    compileSdk = 36

    defaultConfig {
        applicationId = "com.example.camera"
        minSdk = 31
        targetSdk = 36
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
}

dependencies {

    implementation(libs.appcompat)
    implementation(libs.material)
    implementation(libs.activity)
    implementation(libs.constraintlayout)
    implementation(libs.firebase.crashlytics.buildtools)
    testImplementation(libs.junit)
    androidTestImplementation(libs.ext.junit)
    androidTestImplementation(libs.espresso.core)
    // CameraX core library using the camera2 implementation
    val camerax_version = "1.7.0-alpha01"
    // The following line is optional, as the core library is included indirectly by camera-camera2
    implementation("androidx.camera:camera-core:1.3.4")
    implementation("androidx.camera:camera-camera2:1.3.4")
    // If you want to additionally use the CameraX Lifecycle library
    implementation("androidx.camera:camera-lifecycle:1.3.4")
    // If you want to additionally use the CameraX VideoCapture library
    implementation("androidx.camera:camera-video:1.3.4")
    // If you want to additionally use the CameraX View class
    implementation("androidx.camera:camera-view:1.3.4")
    // If you want to additionally add CameraX ML Kit Vision Integration
    implementation("androidx.camera:camera-mlkit-vision:1.3.4")
    // If you want to additionally use the CameraX Extensions library
    implementation("androidx.camera:camera-extensions:1.3.4")

}