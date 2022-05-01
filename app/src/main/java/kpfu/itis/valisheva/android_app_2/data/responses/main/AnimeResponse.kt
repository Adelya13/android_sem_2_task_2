package kpfu.itis.valisheva.android_app_2.data.responses.main

import com.google.gson.annotations.SerializedName
import kpfu.itis.valisheva.android_app_2.data.responses.BigImage
import kpfu.itis.valisheva.android_app_2.data.responses.Genre

data class AnimeResponse(
    @SerializedName("title_english")
    val title: String,
    @SerializedName("images")
    val bigImage: BigImage,
    @SerializedName("score")
    val score: Double,
    @SerializedName("status")
    val status: String,
    @SerializedName("rating")
    val rating: String,
    @SerializedName("genres")
    val genres: ArrayList<Genre>,


    )

