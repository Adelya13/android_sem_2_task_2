package kpfu.itis.valisheva.android_app_2.data.repository

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

    override suspend fun getAnimeById(id: Int): AnimeFullInfo {
        return animeMapper.mapAnimeInfo(api.getAnimeById(id))
    }

    override suspend fun getAnimeByName(name: String): ArrayList<AnimeShortInfo> {
        return animeMapper.mapAnimeList(api.getAnimeByName(name))
    }

    override suspend fun getTopAnime(): ArrayList<AnimeShortInfo> {
        return animeMapper.mapAnimeList(api.getTopAnime())
    }

}
