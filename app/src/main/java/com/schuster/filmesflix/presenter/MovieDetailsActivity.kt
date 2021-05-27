package com.schuster.filmesflix.presenter

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import coil.load
import com.schuster.filmesflix.R
import com.schuster.filmesflix.databinding.ActivityMovieDetailsBinding


class MovieDetailsActivity : AppCompatActivity() {

    lateinit var binding : ActivityMovieDetailsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMovieDetailsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.movieTitle.text = intent.getStringExtra("TITULO")
        binding.movieDataLancamento.text = intent.getStringExtra("DATA_LANCAMENTO")
        binding.movieDescriptionn.text = intent.getStringExtra("DESCRICAO")
        binding.movieImage.load(intent.getStringExtra("IMAGEM")) {
            placeholder(R.drawable.ic_image)
            fallback(R.drawable.ic_image)
        }
    }
}