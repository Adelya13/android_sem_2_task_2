package kpfu.itis.valisheva.android_app_2.data.api

import kpfu.itis.valisheva.android_app_2.data.responses.main.AnimeListResponse
import kpfu.itis.valisheva.android_app_2.data.responses.main.AnimeResponse
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query


interface Api{

    @GET("anime/{id}")
    suspend fun getAnimeById(
       @Path("id") id: Int
    ): AnimeResponse

    @GET("anime")
    suspend fun getAnimeByName(
        @Query("q") name : String
    ): AnimeListResponse

    @GET("top/anime?filter=bypopularity")
    suspend fun getTopAnime(): AnimeListResponse

}

