package kpfu.itis.valisheva.android_app_2.domain.repositories

import kpfu.itis.valisheva.android_app_2.domain.entities.AnimeFullInfo
import kpfu.itis.valisheva.android_app_2.domain.entities.AnimeShortInfo

interface AnimeRepository {

    suspend fun getAnimeById(int: Int): AnimeFullInfo
    suspend fun getAnimeByName(name: String) : ArrayList<AnimeShortInfo>
    suspend fun getTopAnime(): ArrayList<AnimeShortInfo>

}
