package com.schuster.filmesflix.usecase

import com.schuster.filmesflix.data.MovieRepository

class MoviesListUseCase(private val movieRepository: MovieRepository) {

    suspend operator fun invoke() = movieRepository.getAllMoviesFromDataSource()

}