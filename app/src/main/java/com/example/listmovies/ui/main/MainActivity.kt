package com.example.listmovies.ui.main

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.listmovies.ui.movie.MoviesFragment
import com.example.listmovies.R

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        supportFragmentManager
            .beginTransaction()
            .addToBackStack(MoviesFragment::javaClass.name)
            .replace(R.id.movieLayoutContainer, MoviesFragment.newInstance())
            .commit()
    }
}