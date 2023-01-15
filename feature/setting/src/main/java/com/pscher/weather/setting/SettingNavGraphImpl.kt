package com.pscher.weather.setting

import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.rememberCoroutineScope
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.pscher.weather.setting.screen.SettingScreen
import com.pscher.weather.setting.screen.SettingVM
import com.pscher.weather.settingapi.SettingDestinations
import com.pscher.weather.settingapi.SettingNavGraph
import com.pscher.weather.settingapi.SettingNavigationActions
import kotlinx.coroutines.launch
import timber.log.Timber
import javax.inject.Inject

class SettingNavGraphImpl @Inject constructor(
    private val settingVM: SettingVM,
): SettingNavGraph {

    init {
        Timber.e("Create SettingNavGraphImpl")
    }

    override fun NavGraphBuilder.addSettingNavGraph(navigationActions: SettingNavigationActions) {
        composable(SettingDestinations.SETTING_ROUTE) {
            val scope = rememberCoroutineScope()
            SettingScreen(
                uiState = settingVM.settingUiState.collectAsState().value,
                onClickBack = { navigationActions.back() },
                onChangeThemeLight = {
                    scope.launch {
                        settingVM.changeThemeLight(it)
                    }
                }
            )
        }
    }
}