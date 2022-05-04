plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
    id("com.google.gms.google-services")
    id("kotlin-kapt")
}

android {

    compileSdk = ProjectSetting.PROJECT_COMPILE_SDK

    defaultConfig {
        applicationId = ProjectSetting.PROJECT_APP_ID
        minSdk = ProjectSetting.PROJECT_MIN_SDK
        targetSdk = ProjectSetting.PROJECT_TARGET_SDK
        versionCode = ProjectSetting.PROJECT_VERSION_CODE
        versionName = ProjectSetting.PROJECT_VERSION_NAME

        multiDexEnabled = true
        vectorDrawables.useSupportLibrary = true

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"

        // Naming APK // AAB
        setProperty("archivesBaseName", "${ProjectSetting.NAME_APK}(${versionName})")

        // Declaration build config
        buildConfigField("String", "DB_ROOM", "\"${ProjectSetting.DB}\"")
        buildConfigField("String", "PREF_NAME", "\"${ProjectSetting.PREF_NAME}\"")

        buildConfigField("String", "NAME_APP", "\"${ProjectSetting.NAME_APP}\"")

        // Inject app name for debug
        resValue("string", "app_name", ProjectSetting.NAME_APP_DEBUG)

        // Inject admob id for debug
        resValue("string", "admob_app_id", ProjectSetting.DEBUG_ADMOB_APP_ID)

    }

    signingConfigs {
        create("release") {
            // You need to specify either an absolute path or include the
            // keystore file in the same directory as the build.gradle file.
            // [PROJECT FOLDER NAME/app/[COPY YOUT KEY STORE] .jks in here
            storeFile = file(ProjectSetting.PLAYSTORE_STORE_FILE)
            storePassword = ProjectSetting.PLAYSTORE_STORE_PASSWORD
            keyAlias = ProjectSetting.PLAYSTORE_KEY_ALIAS
            keyPassword = ProjectSetting.PLAYSTORE_KEY_PASSWORD
        }
    }

    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
            isDebuggable = false
            isJniDebuggable = false
            isRenderscriptDebuggable = false
            isPseudoLocalesEnabled = false

            // Generated Signed APK / AAB
            signingConfig = signingConfigs.getByName("release")

            // Inject app name for release
            resValue("string", "app_name", ProjectSetting.NAME_APP)

            // Inject admob id for release
            resValue("string", "admob_app_id", ProjectSetting.RELEASE_ADMOB_APP_ID)

            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }

    lint {
        abortOnError = false
        checkReleaseBuilds = false
    }

    buildFeatures {
        viewBinding = true
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }

    packagingOptions {
        resources {
            excludes += setOf("META-INF/AL2.0", "META-INF/LGPL2.1")
        }
    }

    tasks.withType<org.jetbrains.kotlin.gradle.tasks.KotlinCompile> {
        kotlinOptions {
            jvmTarget = JavaVersion.VERSION_11.toString()
        }
    }

}

dependencies {

    implementation(Androidx.Core.ktx)
    implementation(Androidx.Work.runtime)
    implementation(Androidx.Work.runtimeKtx)

    implementation(Androidx.appCompat)
    implementation(Androidx.preferenceKtx)
    implementation(Androidx.constraintLayout)
    implementation(Androidx.collection)

    implementation(Androidx.Lifecycle.runtimeKtx)
    implementation(Androidx.Lifecycle.viewmodelKtx)
    implementation(Androidx.Lifecycle.livedataKtx)
    implementation(Androidx.Lifecycle.reactivestreamsKtx)

    implementation(Androidx.Room.runtime)
    implementation(Androidx.Room.ktx)
    implementation(Androidx.Room.rxJava3)

    implementation(Google.gson)
    implementation(Google.material)
    implementation(Google.admob)

    implementation(Reactivex.rxJava3)
    implementation(Reactivex.rxAndroid3)

    implementation(Koin.core)
    implementation(Koin.android)
    implementation(Koin.androidCompat)
    implementation(Koin.androidxWorkManager)

    implementation(Frogo.ui)
    implementation(Frogo.sdk)

    implementation(Frogo.admob)
    implementation(Frogo.consumeApi)
    implementation(Frogo.recyclerView)

    implementation(GitHub.glide)
    implementation(Util.hdodenhofCircleImageView)
    implementation(GitHub.chucker)

    implementation("androidx.legacy:legacy-support-v4:1.0.0")
    implementation("androidx.swiperefreshlayout:swiperefreshlayout:1.1.0")

    implementation("com.google.firebase:firebase-analytics:20.1.2")
    implementation("com.google.firebase:firebase-messaging:23.0.3")

    implementation("com.github.ismaeldivita:chip-navigation-bar:1.4.0")
    implementation("com.github.PhilJay:MPAndroidChart:v3.1.0")

    kapt(Androidx.Lifecycle.compiler)
    kapt(Androidx.Room.compiler)
    kapt(GitHub.glideCompiler)

}