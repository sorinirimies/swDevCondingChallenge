package com.ekremsenturk.themoviesdb

import android.app.Application
import com.ekremsenturk.themoviesdb.di.appModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class TheMoviesDBApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin{
            androidLogger()
            androidContext(this@TheMoviesDBApplication)
            modules(appModule)
        }
    }

}