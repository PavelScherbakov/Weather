package com.pscher.weather.main

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.collectAsState
import com.pscher.weather.coreapi.AppWithFacade
import com.pscher.weather.datastore.repository.AppSettingDataStore
import com.pscher.weather.main.di.MainActivityComponent
import com.pscher.weather.navigationapi.MasterNavGraphMediator
import javax.inject.Inject

class MainActivity : ComponentActivity() {

    @Inject
    lateinit var masterNavGraphMediator: MasterNavGraphMediator

    //@Inject
    //lateinit var appSettingDataStore: AppSettingDataStore


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        MainActivityComponent.create((application as AppWithFacade).getFacade()).inject(this)

        setContent {
            //val isDarkTheme = appSettingDataStore.appThemeLight().get().collectAsState(initial = false)
            val isDarkTheme = false

            App(
                //isDarkTheme = isDarkTheme.value ?: false,
                isDarkTheme = isDarkTheme,
            ) { _ ->
                masterNavGraphMediator.provideMasterNavGraph().MasterNavHostGraph()
            }
        }
    }
}