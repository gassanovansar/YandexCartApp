package com.example.yandexcartapp.di

import org.koin.core.context.startKoin

object KoinInjector {

    val koinApp = startKoin {
        modules(
            listOf(
                useCaseModule,
                repositoryModule,
                sourceModule
            )

        )
    }
}