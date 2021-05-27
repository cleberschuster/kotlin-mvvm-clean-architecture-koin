package com.schuster.filmesflix.data

class MovieRepository(private val movieDataSource: MovieDataSource) {

    suspend fun getAllMoviesFromDataSource() = movieDataSource.getAllMoviesCoroutines()

}