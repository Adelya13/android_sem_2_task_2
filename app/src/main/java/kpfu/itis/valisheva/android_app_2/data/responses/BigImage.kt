package kpfu.itis.valisheva.android_app_2.data.responses

import com.google.gson.annotations.SerializedName

data class BigImage(
    @SerializedName("jpg")
    val srcJpg: SrcJpgBig,
)

data class SrcJpgBig(
    @SerializedName("image_url")
    val url: String,
)
