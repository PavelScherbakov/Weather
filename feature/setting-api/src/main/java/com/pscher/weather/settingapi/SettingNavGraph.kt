package com.pscher.weather.settingapi

import androidx.navigation.NavGraphBuilder

interface SettingNavGraph {
    fun NavGraphBuilder.addSettingNavGraph(navigationActions: SettingNavigationActions)
}