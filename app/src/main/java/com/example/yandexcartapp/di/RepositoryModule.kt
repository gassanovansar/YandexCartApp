package com.example.yandexcartapp.di

import com.example.yandexcartapp.data.CartInteractorImpl
import com.example.yandexcartapp.domain.repository.CartInteractor
import org.koin.dsl.module

val repositoryModule = module {
    single<CartInteractor> { CartInteractorImpl(get()) }
}