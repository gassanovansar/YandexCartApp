package com.example.yandexcartapp

import android.app.Application
import com.example.yandexcartapp.di.KoinInjector
import org.koin.android.ext.koin.androidContext

class AndroidApp : Application() {

    override fun onCreate() {
        super.onCreate()
        KoinInjector.koinApp.androidContext(this)
    }
}

