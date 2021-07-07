package com.example.listmovies.ui.movie

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.listmovies.R
import com.example.listmovies.data.model.Movie
import com.example.listmovies.util.Constant.BASE_URL_IMAGE
import com.example.listmovies.util.OnItemClickListener
import kotlinx.android.synthetic.main.item_movie.view.*

class MoviesAdapter(private val listener: OnItemClickListener) :
    RecyclerView.Adapter<MoviesAdapter.ViewHolder?>() {
    private val movies = mutableListOf<Movie>()

    fun setData(movies: List<Movie>?) {
        movies?.let {
            this.movies.clear()
            this.movies.addAll(it)
            notifyDataSetChanged()
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_movie, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindViewData(movies[position], listener, position)

        holder.itemView.setOnClickListener {
            listener.onItemClick(movies[position])
        }
    }

    override fun getItemCount() = movies.size

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val imgImage: ImageView = itemView.imgImage
        private val tvTitle: TextView = itemView.tvTitle
        private val tvOriginTitle: TextView = itemView.tvOriginTitle
        private val tvRating: TextView = itemView.tvRating

        fun bindViewData(movie: Movie, listener: OnItemClickListener, position: Int) {
            Glide.with(imgImage).load(BASE_URL_IMAGE + movie.urlImage).circleCrop().into(imgImage)
            tvTitle.text = movie.title
            tvOriginTitle.text = movie.originalTitle
            tvRating.text = movie.vote.toString()
        }
    }
}