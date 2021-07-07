package com.example.listmovies.data.api

import com.example.listmovies.data.model.Page
import com.example.listmovies.util.Constant.BASE_API_KEY
import com.example.listmovies.util.Constant.BASE_LANGUAGE
import com.example.listmovies.util.Constant.BASE_PAGE
import com.example.listmovies.util.Constant.BASE_URL
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

interface ApiService {

    @GET("3/movie/top_rated?$BASE_PAGE$BASE_API_KEY$BASE_LANGUAGE")
    fun getPages(): Call<Page>

    companion object {
        fun apiService(): ApiService {
            val retrofit = Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()

            return retrofit.create(ApiService::class.java)
        }
    }
}