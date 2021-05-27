package com.schuster.filmesflix.framework.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.schuster.filmesflix.data.MovieRepository
import com.schuster.filmesflix.domain.Movie
import com.schuster.filmesflix.framework.api.MovieRestApiTask
import com.schuster.filmesflix.implementations.MovieDataSourceImplementation
import com.schuster.filmesflix.usecase.MoviesListUseCase
import kotlinx.coroutines.launch

class MovieListViewModel: ViewModel() {

    companion object {
        const val TAG = "MovieRepository"
    }

    private val movieRestApiTask = MovieRestApiTask()
    private val movieDataSource = MovieDataSourceImplementation(movieRestApiTask)
    private val movieRepository = MovieRepository(movieDataSource)
    private val moviesListUseCase = MoviesListUseCase(movieRepository)

    private var _moviesList = MutableLiveData<List<Movie>>()
    val moviesList: LiveData<List<Movie>>
        get() = _moviesList

    fun init() {
        getAllMoviesCoroutines()
    }

    private fun getAllMoviesCoroutines() {

        viewModelScope.launch {

            try {
                _moviesList.value = moviesListUseCase.invoke()

            } catch (exception: Exception) {
                Log.d(TAG, exception.message.toString())
            }
        }
    }
}