package com.schuster.filmesflix.di

import com.schuster.filmesflix.framework.viewmodel.MovieListViewModel
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {
    viewModel { MovieListViewModel() }
}