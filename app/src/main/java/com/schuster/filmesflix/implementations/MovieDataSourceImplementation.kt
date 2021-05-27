package com.schuster.filmesflix.implementations

import android.util.Log
import com.schuster.filmesflix.data.MovieDataSource
import com.schuster.filmesflix.domain.Movie
import com.schuster.filmesflix.framework.api.MovieRestApiTask
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class MovieDataSourceImplementation(private val movieRestApiTask: MovieRestApiTask): MovieDataSource {

    companion object {
        const val TAG = "MovieRepository"
    }

    private val movieList = arrayListOf<Movie>()

    override suspend fun getAllMoviesCoroutines(): List<Movie> {
        return withContext(Dispatchers.IO) {
            val request = movieRestApiTask.retrofitApi().getAllMovies().execute()

            if (request.isSuccessful) {
                request.body()?.let {
                    movieList.addAll(it)
                }
            } else {
                request.errorBody()?.let {
                    Log.d(TAG, it.toString())
                }
            }

            return@withContext movieList
        }
    }
}