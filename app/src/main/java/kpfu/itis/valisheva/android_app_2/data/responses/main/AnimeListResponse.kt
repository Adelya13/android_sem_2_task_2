package kpfu.itis.valisheva.android_app_2.data.responses.main

import com.google.gson.annotations.SerializedName
import kpfu.itis.valisheva.android_app_2.data.responses.AnimeShortInfoResp

data class AnimeListResponse(
    @SerializedName("data")
    val animeList : ArrayList<AnimeShortInfoResp>
)
