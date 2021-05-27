package com.schuster.filmesflix.presenter

import com.schuster.filmesflix.domain.Movie

interface ClickItemMoviesListener {

    fun onItemClickListener(movie: Movie)
    fun onItemLongClickListener(movie: Movie)
}