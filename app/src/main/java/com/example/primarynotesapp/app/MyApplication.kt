package com.example.primarynotesapp.app

import android.app.Application
import com.example.primarynotesapp.di.appModule
import com.example.primarynotesapp.di.viewModel
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class MyApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@MyApplication)
            modules(appModule, viewModel)
        }
    }
}