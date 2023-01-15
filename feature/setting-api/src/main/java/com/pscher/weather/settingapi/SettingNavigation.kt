package com.pscher.weather.settingapi

import com.pscher.weather.settingapi.SettingScreens.SETTING_SCREEN

object SettingScreens {
    const val SETTING_SCREEN = "SettingScreen"
}

object SettingDestinationsArgs {
    //const val USER_MESSAGE_ARG = "userMessage"
}

object SettingDestinations {
    const val SETTING_ROUTE = "$SETTING_SCREEN"
}

interface SettingNavigationActions {
    fun back()
}