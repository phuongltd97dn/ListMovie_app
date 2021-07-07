package com.example.listmovies.ui.detail

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.listmovies.data.model.Movie

class DetailViewModel() : ViewModel() {

    var movie: MutableLiveData<Movie> = MutableLiveData()

    fun setMovie(movie: Movie?) {
        this.movie.value = movie
    }

}