/*
 * Created by faisalamir on 19/09/21
 * FrogoRecyclerView
 * -----------------------------------------
 * Name     : Muhammad Faisal Amir
 * E-mail   : faisalamircs@gmail.com
 * Github   : github.com/amirisback
 * -----------------------------------------
 * Copyright (C) 2021 FrogoBox Inc.
 * All rights reserved
 *
 */

object ProjectSetting {

    // ---------------------------------------------------------------------------------------------

    // Project settings
    const val NAME_APP = "Pantaucovid"

    const val APP_DOMAIN = "com"
    const val APP_PLAY_CONSOLE = "sunflower"
    private val APP_NAME = "pantaucovid19"

    const val VERSION_MAJOR = 1
    const val VERSION_MINOR = 0
    const val VERSION_PATCH = 1

    // ---------------------------------------------------------------------------------------------

    // Key Store
    const val PLAYSTORE_STORE_FILE = "suncode.jks"
    const val PLAYSTORE_STORE_PASSWORD = "amirisback"
    const val PLAYSTORE_KEY_ALIAS = "suncode"
    const val PLAYSTORE_KEY_PASSWORD = "amirisback"

    // ---------------------------------------------------------------------------------------------

    // Declaration admob id for release
    const val RELEASE_ADMOB_APP_ID = "ca-app-pub-3940256099942544~3347511713" // Wajib

    // Declaration Speed Games
    const val PIANO_TILES_SPEED_GAME = 11

    // ---------------------------------------------------------------------------------------------
    // Default Setting - Do Not Change
    // ---------------------------------------------------------------------------------------------

    const val PROJECT_MIN_SDK = 23
    const val PROJECT_COMPILE_SDK = Version.Gradle.compileSdk
    const val PROJECT_TARGET_SDK = PROJECT_COMPILE_SDK

    // ---------------------------------------------------------------------------------------------

    val PROJECT_APP_ID = "$APP_DOMAIN.$APP_PLAY_CONSOLE.$APP_NAME"
    const val PROJECT_VERSION_CODE =
        (VERSION_MAJOR * 100) + (VERSION_MINOR * 10) + (VERSION_PATCH * 1)
    const val PROJECT_VERSION_NAME = "$VERSION_MAJOR.$VERSION_MINOR.$VERSION_PATCH"

    // ---------------------------------------------------------------------------------------------

    // Declaration apps name debug mode
    const val DEBUG_ATTRIBUTE = "Development"
    const val NAME_APP_DEBUG = "$NAME_APP $DEBUG_ATTRIBUTE"

    // Constant Variable
    val NAME_APK = NAME_APP.toLowerCase().replace(" ", "-")
    private val NAME_SETTING_LOWERCASE = NAME_APP.toLowerCase().replace(" ", "_")
    private val NAME_SETTING_UPERCASE = NAME_APP.toUpperCase().replace(" ", "_")
    val DB = "db_$NAME_SETTING_LOWERCASE.db"
    val PREF_NAME = "PREF_GAME_$NAME_SETTING_UPERCASE"

    // Declaration admob id for debug
    const val DEBUG_ADMOB_APP_ID = "ca-app-pub-3940256099942544~3347511713"

    // Base URL end with "/"
    const val SERVER_NAME = "https://amirisback.github.io"
    private const val REPOSITORY_SERVER_NAME = "suncode-remote-data-source"
    private const val BASE_URL_ADMOB_SERVER = "$SERVER_NAME/$REPOSITORY_SERVER_NAME/src/main/api/v1/app"
    val URL_ADMOB_SERVER = "$BASE_URL_ADMOB_SERVER/$APP_PLAY_CONSOLE/$NAME_APK/"
    const val JSON_MONETIZE_ADS = "monetize-apps.json"
    const val JSON_MUSIC = "music.json"

}