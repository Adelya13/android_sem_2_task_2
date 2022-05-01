package kpfu.itis.valisheva.android_app_2.domain.usecases

import io.reactivex.rxjava3.core.Scheduler
import io.reactivex.rxjava3.core.Single
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import kpfu.itis.valisheva.android_app_2.di.qualifiers.SchedulerIOInterceptor
import kpfu.itis.valisheva.android_app_2.domain.entities.AnimeFullInfo
import kpfu.itis.valisheva.android_app_2.domain.entities.AnimeShortInfo
import kpfu.itis.valisheva.android_app_2.domain.repositories.AnimeRepository
import javax.inject.Inject

class GetAnimeByIdUseCase @Inject constructor(
    private val animeRepository: AnimeRepository,
    @SchedulerIOInterceptor private val schedulerIo: Scheduler
){
    operator fun invoke(
        id: Int
    ): Single<AnimeFullInfo>
    {
        return animeRepository
            .getAnimeById(id)
            .subscribeOn(schedulerIo)
    }
}
