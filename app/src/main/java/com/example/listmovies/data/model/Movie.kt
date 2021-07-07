package com.example.listmovies.data.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Movie(
    @SerializedName("backdrop_path")
    var backDropImage: String = "",

    @SerializedName("overview")
    var overView: String = "",

    @SerializedName("vote_average")
    var vote: Double = 0.0,

    @SerializedName("vote_count")
    var voteCount: Int = 0,

    var title: String = "",

    @SerializedName("poster_path")
    var urlImage: String = "",

    @SerializedName("original_title")
    var originalTitle: String = ""
) : Parcelable