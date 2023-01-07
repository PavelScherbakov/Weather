package com.pscher.weather.coreapi

import javax.inject.Provider

interface MediatorsProvider {
    fun mediatorsMap(): Map<Class<*>, @JvmSuppressWildcards Provider<Any>>
}
