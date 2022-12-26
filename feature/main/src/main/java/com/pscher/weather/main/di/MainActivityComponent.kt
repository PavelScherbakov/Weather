package com.pscher.weather.main.di

import com.pscher.weather.main.MainActivity
import dagger.Component

@Component
interface MainActivityComponent {
    fun inject (mainActivity: MainActivity)
}