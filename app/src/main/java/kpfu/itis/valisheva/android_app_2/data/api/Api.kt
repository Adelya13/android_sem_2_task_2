package kpfu.itis.valisheva.android_app_2.data.api

import io.reactivex.rxjava3.core.Single
import kpfu.itis.valisheva.android_app_2.data.responses.main.AnimeListResponse
import kpfu.itis.valisheva.android_app_2.data.responses.main.AnimeResponse
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query


interface Api{

    @GET("anime/{id}")
    fun getAnimeById(
       @Path("id") id: Int
    ): Single<AnimeResponse>

    @GET("anime")
    fun getAnimeByName(
        @Query("q") name : String
    ): Single<AnimeListResponse>

    @GET("top/anime?filter=bypopularity")
    fun getTopAnime(): Single<AnimeListResponse>

}

