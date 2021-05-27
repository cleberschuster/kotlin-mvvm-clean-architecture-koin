package com.schuster.filmesflix.data

import com.schuster.filmesflix.domain.Movie

interface MovieDataSource {

    suspend fun getAllMoviesCoroutines(): List<Movie>

}