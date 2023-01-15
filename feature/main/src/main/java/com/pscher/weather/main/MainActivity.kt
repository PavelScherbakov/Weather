package com.pscher.weather.main

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.collectAsState
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import com.pscher.weather.coreapi.AppWithFacade
import com.pscher.weather.datastore.repository.AppDataRepository
import com.pscher.weather.datastore.repository.AppSettingDataStore
import com.pscher.weather.main.di.MainActivityComponent
import com.pscher.weather.navigationapi.MasterNavGraphMediator
import com.pscher.weather.ui.uikit.AppThemeParam
import javax.inject.Inject

class MainActivity : ComponentActivity() {

    @Inject
    lateinit var masterNavGraphMediator: MasterNavGraphMediator

    @Inject
    lateinit var appDataRepository: AppDataRepository


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        MainActivityComponent.create((application as AppWithFacade).getFacade()).inject(this)

        setContent {
            val systemUiController = rememberSystemUiController()
            val isDarkTheme = appDataRepository.appSettingDataStore().appDarkTheme().get().collectAsState(initial = false)

            App(
                isDarkTheme = isDarkTheme.value ?: false,
            ) { _ ->
                //Устанавливаем цвет статус-бара
                systemUiController.setSystemBarsColor(
                    color = AppThemeParam.colors.primary,
                )

                masterNavGraphMediator.provideMasterNavGraph().MasterNavHostGraph()
            }
        }
    }
}