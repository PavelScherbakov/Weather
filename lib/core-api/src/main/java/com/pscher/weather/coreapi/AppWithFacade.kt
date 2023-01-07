package com.pscher.weather.coreapi

interface AppWithFacade {
    fun getFacade(): ProvidersFacade
}