package com.example.listmovies.util

import com.example.listmovies.data.model.Movie

interface OnItemClickListener {

    fun onItemClick(movie: Movie?)

}