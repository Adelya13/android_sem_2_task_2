package kpfu.itis.valisheva.android_app_2.domain.entities

data class AnimeFullInfo (
    val title: String,
    val imagePath: String,
    val score: Double,
    val status: String,
    val rating: String,
    val genres: ArrayList<String>,
)
