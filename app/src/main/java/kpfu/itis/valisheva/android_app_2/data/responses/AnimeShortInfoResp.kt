package kpfu.itis.valisheva.android_app_2.data.responses

import com.google.gson.annotations.SerializedName

data class AnimeShortInfoResp (
    @SerializedName("mal_id")
    val id: Int,
    @SerializedName("title_english")
    val title: String,
    @SerializedName("images")
    val smallImage: SmallImage,
    @SerializedName("score")
    val score: Double,

)
