package kpfu.itis.valisheva.android_app_2.data.api.mappers

import kpfu.itis.valisheva.android_app_2.data.responses.AnimeShortInfoResp
import kpfu.itis.valisheva.android_app_2.data.responses.Genre
import kpfu.itis.valisheva.android_app_2.data.responses.main.AnimeListResponse
import kpfu.itis.valisheva.android_app_2.data.responses.main.AnimeResponse
import kpfu.itis.valisheva.android_app_2.domain.entities.AnimeFullInfo
import kpfu.itis.valisheva.android_app_2.domain.entities.AnimeShortInfo

class AnimeMapper {

    fun mapAnimeInfo(response: AnimeResponse): AnimeFullInfo = AnimeFullInfo(
        title = response.title,
        imagePath = response.bigImage.srcJpg.url,
        score = response.score,
        status = response.status,
        rating = response.rating,
        genres = convertGenre(response.genres)
    )

    fun mapAnimeList(response: AnimeListResponse) : ArrayList<AnimeShortInfo>{
        return convertAnimeList(response.animeList)
    }



    private fun convertAnimeList(respAnime : ArrayList<AnimeShortInfoResp>): ArrayList<AnimeShortInfo>{
        val anime: ArrayList<AnimeShortInfo> = arrayListOf()

        respAnime.forEach{
            anime.add(
                AnimeShortInfo(
                    id = it.id,
                    title = it.title,
                    imagePath = it.smallImage.srcJpg.url,
                    score = it.score
                )
            )
        }
        return anime
    }

    private fun convertGenre(genreRespList : ArrayList<Genre>): ArrayList<String>{
        var genre: ArrayList<String> = arrayListOf()
        genreRespList.forEach{
            genre.add(it.name)
        }
        return genre
    }
}
