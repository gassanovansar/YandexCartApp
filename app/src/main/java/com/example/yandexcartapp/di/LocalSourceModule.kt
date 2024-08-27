package com.example.yandexcartapp.di

import com.example.yandexcartapp.data.localSource.LocalSource
import org.koin.dsl.module

val sourceModule = module {
    single<LocalSource> { LocalSource() }

}