package kpfu.itis.valisheva.android_app_2.data.responses

import com.google.gson.annotations.SerializedName

data class SmallImage(
    @SerializedName("jpg")
    val srcJpg: SrcJpgSmall,
)

data class SrcJpgSmall(
    @SerializedName("small_image_url")
    val url: String,
)
