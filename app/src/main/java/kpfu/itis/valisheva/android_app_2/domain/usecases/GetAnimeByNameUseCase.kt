package kpfu.itis.valisheva.android_app_2.domain.usecases

import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import kpfu.itis.valisheva.android_app_2.domain.entities.AnimeShortInfo
import kpfu.itis.valisheva.android_app_2.domain.repositories.AnimeRepository
import javax.inject.Inject

class GetAnimeByNameUseCase @Inject constructor(
    private val animeRepository: AnimeRepository,
    private val dispatcher: CoroutineDispatcher = Dispatchers.IO
) {
    suspend operator fun invoke(name: String): ArrayList<AnimeShortInfo>{
        return withContext(dispatcher){
            animeRepository.getAnimeByName(name)
        }
    }
}
