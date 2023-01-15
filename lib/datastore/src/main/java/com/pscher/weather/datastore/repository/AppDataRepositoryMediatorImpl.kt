package com.pscher.weather.datastore.repository

import timber.log.Timber
import javax.inject.Inject

interface AppDataRepositoryMediator {
    fun provideAppDataRepository(): AppDataRepository
}

class AppDataRepositoryMediatorImpl @Inject constructor(
    private val appDataRepository: AppDataRepository,
): AppDataRepositoryMediator {
    init {
        Timber.e("Create AppDataRepositoryMediatorImpl")
    }

    override fun provideAppDataRepository(): AppDataRepository {
        return appDataRepository
    }

}