package kpfu.itis.valisheva.android_app_2.domain.usecases

import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import kpfu.itis.valisheva.android_app_2.domain.entities.AnimeFullInfo
import kpfu.itis.valisheva.android_app_2.domain.repositories.AnimeRepository
import javax.inject.Inject

class GetAnimeByIdUseCase @Inject constructor(
    private val animeRepository: AnimeRepository,
    private val dispatcher: CoroutineDispatcher = Dispatchers.IO
){
    suspend operator fun invoke(id: Int): AnimeFullInfo {
        return withContext(dispatcher){
            animeRepository.getAnimeById(id)
        }
    }
}
