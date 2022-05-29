package com.ekremsenturk.themoviesdb

import android.app.Application
import com.ekremsenturk.core.di.coreModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import timber.log.Timber

class TheMoviesDBApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        Timber.plant(Timber.DebugTree())
        startKoin{
            androidLogger()
            androidContext(this@TheMoviesDBApplication)
            modules(coreModule)
        }
    }

}