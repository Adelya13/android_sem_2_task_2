package kpfu.itis.valisheva.android_app_2.di.modules

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kpfu.itis.valisheva.android_app_2.data.repository.AnimeRepositoryImpl
import kpfu.itis.valisheva.android_app_2.data.repository.AnimeRepositoryImpl_Factory
import kpfu.itis.valisheva.android_app_2.domain.repositories.AnimeRepository


@Module
@InstallIn(SingletonComponent::class)
interface RepositoryModule {
    @Binds
    fun weatherRepository(
        impl: AnimeRepositoryImpl
    ): AnimeRepository
}
