package com.example.listmovies.ui.detail

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.bumptech.glide.Glide
import com.example.listmovies.R
import com.example.listmovies.data.model.Movie
import com.example.listmovies.util.Constant.BASE_URL_IMAGE
import kotlinx.android.synthetic.main.fragment_detail.*

class DetailFragment : Fragment() {

    private lateinit var detailViewModel: DetailViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragmen
        return inflater.inflate(R.layout.fragment_detail, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        detailViewModel = ViewModelProvider(this).get(DetailViewModel::class.java)

        arguments?.run {
            detailViewModel.setMovie(getParcelable(ARGUMENT_MOVIE))
        }

        detailViewModel.movie.observe(requireActivity(), Observer {
            Glide.with(imgBackDrop).load(BASE_URL_IMAGE + it.backDropImage).into(imgBackDrop)
            Glide.with(imgDetailImage).load(BASE_URL_IMAGE + it.urlImage).circleCrop()
                .into(imgDetailImage)
            tvDetailTitle.text = it.title
            tvDescription.text = it.overView
            tvDetailRating.text = it.vote.toString()
            tvReview.text = it.voteCount.toString()
        })

        onButtonBackClickListener()
    }

    private fun onButtonBackClickListener() {
        btnImageBack.setOnClickListener {
            fragmentManager?.popBackStack()
        }
    }

    companion object {
        const val ARGUMENT_MOVIE = "ARGUMENT_MOVIE"

        fun newInstance(movie: Movie?) = DetailFragment().apply {
            arguments = bundleOf(ARGUMENT_MOVIE to movie)
        }
    }
}