package kpfu.itis.valisheva.android_app_2.domain.repositories

import io.reactivex.rxjava3.core.Single
import kpfu.itis.valisheva.android_app_2.domain.entities.AnimeFullInfo
import kpfu.itis.valisheva.android_app_2.domain.entities.AnimeShortInfo

interface AnimeRepository {

    fun getAnimeById(int: Int): Single<AnimeFullInfo>
    fun getAnimeByName(name: String) : Single<MutableList<AnimeShortInfo>>
    fun getTopAnime(): Single<MutableList<AnimeShortInfo>>

}
