package com.ekremsenturk.themoviesdb.di

import com.ekremsenturk.themoviesdb.ui.detail.DetailViewModel
import com.ekremsenturk.themoviesdb.ui.overview.OverviewViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val appModule = module {
    viewModel { OverviewViewModel(get()) }
    viewModel { DetailViewModel(get(), get()) }
}