package com.pscher.weather.setting

import com.pscher.weather.settingapi.SettingNavGraph
import com.pscher.weather.settingapi.SettingNavGraphMediator
import timber.log.Timber
import javax.inject.Inject

class SettingNavGraphMediatorImpl
@Inject constructor(
    private val settingNavGraph: SettingNavGraph,
) : SettingNavGraphMediator {

    init {
        Timber.e("Create SettingNavGraphMediatorImpl")
    }

    override fun provideSettingNavGraph(): SettingNavGraph {
        return settingNavGraph
    }
}