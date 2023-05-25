package de.pirrung.tmbd.challenge.data.di

import de.pirrung.tmbd.challenge.data.repository.TMDBRepositoryImpl
import org.koin.dsl.module

val dataModule = module {
    single { TMDBRepositoryImpl() }
}