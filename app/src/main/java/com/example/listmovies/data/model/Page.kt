package com.example.listmovies.data.model

import com.google.gson.annotations.SerializedName

data class Page(
    val page: Int,
    val results: List<Movie>,
    @SerializedName("total_pages")
    val totalPages: Int,
    @SerializedName("total_results")
    val totalResults: Int,
    @SerializedName("api_key")
    val apiKey: String,
    val language: String
)