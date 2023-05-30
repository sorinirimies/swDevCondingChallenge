package de.pirrung.tmbd.challenge.presentation.di

import de.pirrung.tmbd.challenge.presentation.overview.OverviewViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val presentationModule = module {
    viewModel { OverviewViewModel(get(), get(), get(), get()) }
}