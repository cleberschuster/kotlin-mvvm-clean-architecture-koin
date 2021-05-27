package com.schuster.filmesflix.presenter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.schuster.filmesflix.R
import com.schuster.filmesflix.databinding.MovieItemLayoutBinding
import com.schuster.filmesflix.domain.Movie


class MoviesAdapter(private val moviesList: List<Movie>, private val listener: ClickItemMoviesListener):
        RecyclerView.Adapter<MoviesViewHolder>() {

    private lateinit var binding: MovieItemLayoutBinding

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MoviesViewHolder {

        binding = MovieItemLayoutBinding.inflate(LayoutInflater.from(parent.context),
                parent, false)
        return MoviesViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MoviesViewHolder, position: Int) {
        holder.binding.apply {
            movieTitle.text = moviesList[position].titulo
            movieImage.load(moviesList[position].imagem) {
                placeholder(R.drawable.ic_image)
                fallback(R.drawable.ic_image)
            }

            root.setOnClickListener {
                listener.onItemClickListener(moviesList[position])
            }

            root.setOnLongClickListener {
                listener.onItemLongClickListener(moviesList[position])
                true
            }
        }
    }

    override fun getItemCount(): Int = moviesList.size

}

class MoviesViewHolder(val binding: MovieItemLayoutBinding) : RecyclerView.ViewHolder(binding.root)

