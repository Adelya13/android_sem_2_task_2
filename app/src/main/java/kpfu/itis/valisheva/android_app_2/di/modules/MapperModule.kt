package kpfu.itis.valisheva.android_app_2.di.modules

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kpfu.itis.valisheva.android_app_2.data.api.mappers.AnimeMapper

@Module
@InstallIn(SingletonComponent::class)
class MapperModule {
    @Provides
    fun provideWeatherMapper(): AnimeMapper = AnimeMapper()
}
