plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
    id("com.google.devtools.ksp")
    id("dagger.hilt.android.plugin")
}

android {
    namespace = "com.bakanito.developedwithkotlin"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.bakanito.developedwithkotlin"
        minSdk = 24
        targetSdk = 34
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
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
    buildFeatures {
        viewBinding = true
    }
}

dependencies {

    // Fragment
    implementation("androidx.fragment:fragment-ktx:1.3.2")
    // Activity
    implementation("androidx.activity:activity-ktx:1.2.2")
    // ViewModel
    implementation("androidx.lifecycle:lifecycle-viewmodel-ktx:2.3.1")
    // LiveData
    implementation("androidx.lifecycle:lifecycle-livedata-ktx:2.3.1")
    // Retrofit
    implementation("com.squareup.retrofit2:retrofit:2.9.0")
    implementation("com.squareup.retrofit2:converter-gson:2.9.0")
    //Corrutinas
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-android:1.3.6")
    //Dagger Hilt
    //implementation("com.google.dagger:hilt-android:2.50")
    //kapt("com.google.dagger:hilt-android-compiler:2.50")
    var hilt_version = "2.48"
    implementation("com.google.dagger:hilt-android:$hilt_version")
    ksp("com.google.dagger:hilt-android-compiler:$hilt_version")
    //Room
    var room_version = "2.4.0"
    //implementation("androidx.room:room-runtime:2.4.0")
    //kapt("androidx.room:room-compiler:2.4.0")
    implementation("androidx.room:room-runtime:$room_version")
    implementation("androidx.room:room-ktx:$room_version")
    ksp("androidx.room:room-compiler:$room_version")
    //Piscasso
    implementation("com.squareup.picasso:picasso:2.71828")
    //Gson
    implementation("com.google.code.gson:gson:2.8.9")

    implementation("androidx.core:core-ktx:1.9.0")
    implementation("androidx.appcompat:appcompat:1.6.1")
    implementation("com.google.android.material:material:1.11.0")
    implementation("androidx.constraintlayout:constraintlayout:2.1.4")
    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.5")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")
}