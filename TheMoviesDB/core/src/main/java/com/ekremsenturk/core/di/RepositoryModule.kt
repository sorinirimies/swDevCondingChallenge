package com.ekremsenturk.core.di

import com.ekremsenturk.api.di.serviceModule
import com.ekremsenturk.core.MovieRepository
import com.ekremsenturk.core.MovieRepositoryImpl
import org.koin.dsl.module

val repositoryModule = module {
    single<MovieRepository> { MovieRepositoryImpl(get()) }
}

val coreModule = repositoryModule + serviceModule