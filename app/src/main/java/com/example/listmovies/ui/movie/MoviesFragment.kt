package com.example.listmovies.ui.movie

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.listmovies.R
import com.example.listmovies.data.model.Movie
import com.example.listmovies.ui.detail.DetailFragment
import com.example.listmovies.util.OnItemClickListener
import com.example.listmovies.util.extension.addFragment
import com.example.listmovies.util.extension.replaceFragment
import kotlinx.android.synthetic.main.fragment_list_movie.*

class MoviesFragment : Fragment(), OnItemClickListener {
    private lateinit var moviesAdapter: MoviesAdapter
    private lateinit var moviesViewModel: MoviesViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_list_movie, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initData()
        initMoviesAdapter()
    }

    override fun onItemClick(movie: Movie?) {
        replaceFragment(R.id.movieLayoutContainer, DetailFragment.newInstance(movie))
    }

    private fun initData() {
        val repository = MoviesRepository()
        val moviesViewModelFactory = MoviesViewModelFactory(repository)
        moviesViewModel =
            ViewModelProvider(this, moviesViewModelFactory).get(MoviesViewModel::class.java)
        moviesViewModel.getMovies()
        moviesViewModel.listMovies.observe(requireActivity(), Observer {
            moviesAdapter.setData(it)
        })
    }

    private fun initMoviesAdapter() {
        val layoutManager =
            LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)
        rcvMovie.layoutManager = layoutManager
        moviesAdapter = MoviesAdapter(this)
        rcvMovie.adapter = moviesAdapter
    }


    companion object {
        fun newInstance() = MoviesFragment()
    }

}