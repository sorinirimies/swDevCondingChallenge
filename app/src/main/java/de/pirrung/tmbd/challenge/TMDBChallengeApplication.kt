package de.pirrung.tmbd.challenge

import android.app.Application
import de.pirrung.tmbd.challenge.data.di.dataModule
import de.pirrung.tmbd.challenge.domain.di.domainModule
import de.pirrung.tmbd.challenge.presentation.di.presentationModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class TMDBChallengeApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@TMDBChallengeApplication)
            modules(
                dataModule,
                domainModule,
                presentationModule
            )
        }
    }

}