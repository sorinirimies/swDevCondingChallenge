package de.pirrung.tmbd.challenge.domain.di

import de.pirrung.tmbd.challenge.domain.use_case.GetMovieDetails
import de.pirrung.tmbd.challenge.domain.use_case.GetNowPlayingMovies
import de.pirrung.tmbd.challenge.domain.use_case.GetPopularMovies
import de.pirrung.tmbd.challenge.domain.use_case.GetTopRatedMovies
import de.pirrung.tmbd.challenge.domain.use_case.GetUpcomingMovies
import org.koin.dsl.module

val domainModule = module {
    single { GetPopularMovies(get()) }
    single { GetNowPlayingMovies(get()) }
    single { GetTopRatedMovies(get()) }
    single { GetUpcomingMovies(get()) }
    single { GetMovieDetails(get()) }
}