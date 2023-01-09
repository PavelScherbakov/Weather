package com.pscher.weather.main

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.lifecycle.lifecycleScope
import com.pscher.weather.coreapi.AppWithFacade
import com.pscher.weather.main.di.MainActivityComponent
import com.pscher.weather.navigationapi.MasterNavGraphMediator
import javax.inject.Inject

class MainActivity : ComponentActivity() {

    @Inject
    lateinit var masterNavGraphMediator: MasterNavGraphMediator

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        MainActivityComponent.create((application as AppWithFacade).getFacade()).inject(this)

        setContent {
            App { _ ->
                masterNavGraphMediator.provideMasterNavGraph().MasterNavHostGraph()
            }
        }
    }
}