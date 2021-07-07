package com.example.listmovies.ui.movie

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.listmovies.data.model.Movie
import com.example.listmovies.data.model.Page
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MoviesViewModel(private val repository: MoviesRepository) : ViewModel() {

    val listMovies: MutableLiveData<List<Movie>> = MutableLiveData()

    fun getMovies() {
        repository.getPages().enqueue(object : Callback<Page> {
            override fun onResponse(call: Call<Page>, response: Response<Page>) {
                Log.d("TAG", "onResponse: Call API success!")
                listMovies.value = response.body()?.results
            }

            override fun onFailure(call: Call<Page>, t: Throwable) {
                Log.d("TAG", "onFailure: Call API failed!")
                listMovies.value = null
            }
        })
    }

}