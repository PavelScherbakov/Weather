package com.pscher.weather.setting.screen

import com.pscher.weather.datastore.repository.AppDataRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.runBlocking
import timber.log.Timber
import javax.inject.Inject


class SettingVM @Inject constructor(
    private val appDataRepository: AppDataRepository,
) {

    init {
        Timber.e("Create SettingVM")
    }

    private val _settingUiState = MutableStateFlow(initialSettingUiState)
    val settingUiState: StateFlow<SettingUiState> = _settingUiState.asStateFlow()
    init {
        //Устанавливаем настройки приложения из настроек приложения )
        //todo runBlocking хорошо это или нет в данном случае?
        runBlocking(Dispatchers.IO) {
            val appDarkTheme = appDataRepository.appSettingDataStore().appDarkTheme().get().firstOrNull() ?: false
            Timber.e("SettingVM init appThemeLight = $appDarkTheme")

            _settingUiState.update { settingUiState ->
                settingUiState.copy(
                    appThemeDark = appDarkTheme,
                )
            }
        }
    }

    suspend fun changeThemeLight(checked: Boolean) {
        appDataRepository.appSettingDataStore().appDarkTheme().set(checked)

        _settingUiState.update { settingUiState ->
            settingUiState.copy(
                appThemeDark = checked,
            )
        }
    }
}