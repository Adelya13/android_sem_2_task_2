package kpfu.itis.valisheva.android_app_2.data.repository

import io.reactivex.rxjava3.core.Single
import kpfu.itis.valisheva.android_app_2.data.api.Api
import kpfu.itis.valisheva.android_app_2.data.api.mappers.AnimeMapper
import kpfu.itis.valisheva.android_app_2.domain.entities.AnimeFullInfo
import kpfu.itis.valisheva.android_app_2.domain.entities.AnimeShortInfo
import kpfu.itis.valisheva.android_app_2.domain.repositories.AnimeRepository
import javax.inject.Inject

class AnimeRepositoryImpl @Inject constructor(
    private val api: Api,
    private val animeMapper: AnimeMapper
): AnimeRepository {

    override fun getAnimeById(id: Int): Single<AnimeFullInfo> =
        api.getAnimeById(id).map {
            animeMapper.mapAnimeInfo(it)
        }

    override fun getTopAnime(): Single<MutableList<AnimeShortInfo>> =
        api.getTopAnime().map{
            animeMapper.mapAnimeList(it)
        }

    override fun getAnimeByName(name: String): Single<MutableList<AnimeShortInfo>> =
        api.getAnimeByName(name).map {
            animeMapper.mapAnimeList(it)
        }

}
