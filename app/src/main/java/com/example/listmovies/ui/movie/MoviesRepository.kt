package com.example.listmovies.ui.movie

import com.example.listmovies.data.api.ApiService
import com.example.listmovies.data.model.Page
import retrofit2.Call

class MoviesRepository {

    fun getPages(): Call<Page> {
        return ApiService.apiService().getPages()
    }

}