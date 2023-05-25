package de.pirrung.tmbd.challenge

import android.app.Application
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class TMDBChallengeApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@TMDBChallengeApplication)
            modules(

            )
        }
    }

}