package com.schuster.filmesflix.presenter

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.schuster.filmesflix.databinding.ActivityMainBinding
import com.schuster.filmesflix.domain.Movie
import com.schuster.filmesflix.framework.viewmodel.MovieListViewModel
import org.koin.android.viewmodel.ext.android.viewModel


class MainActivity : AppCompatActivity(), ClickItemMoviesListener {

    private lateinit var binding: ActivityMainBinding
    private val movieListViewModel: MovieListViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        movieListViewModel.init()
        initObserver()
        loadingVisibility(true)
    }

    private fun initObserver() {
        movieListViewModel.moviesList.observe(this, { list ->
            if (list.isNotEmpty()) {
                populateList(list)
                loadingVisibility(false)
            }
        })
    }

    private fun populateList(list: List<Movie>) {
        binding.moviesList.apply {
            hasFixedSize()
            adapter = MoviesAdapter(list, this@MainActivity)
        }
    }

    private fun loadingVisibility(isLoading: Boolean) {
        binding.progressBar.visibility = if (isLoading) View.VISIBLE else View.GONE
    }

    override fun onItemClickListener(movie: Movie) {
        showDetailsMovie(movie)
    }

    override fun onItemLongClickListener(movie: Movie) {
        Toast.makeText(this, "Long click", Toast.LENGTH_LONG).show()
    }

    private fun showDetailsMovie(movie: Movie){

        val intent = Intent(this, MovieDetailsActivity::class.java)
        intent.putExtra("TITULO", movie.titulo)
        intent.putExtra("DESCRICAO", movie.descricao)
        intent.putExtra("IMAGEM", movie.imagem)
        intent.putExtra("DATA_LANCAMENTO", movie.dataLancamento)
        startActivity(intent)
    }

}