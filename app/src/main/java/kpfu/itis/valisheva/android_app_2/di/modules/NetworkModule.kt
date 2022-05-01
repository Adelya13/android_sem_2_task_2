package kpfu.itis.valisheva.android_app_2.di.modules

import androidx.databinding.ktx.BuildConfig
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kpfu.itis.valisheva.android_app_2.data.api.Api
import kpfu.itis.valisheva.android_app_2.di.qualifiers.ApiKeyInterceptor
import kpfu.itis.valisheva.android_app_2.di.qualifiers.LoggingInterceptor
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

private const val BASE_URL = "https://api.jikan.moe/v4/"

@Module
@InstallIn(SingletonComponent::class)
class NetworkModule {

    @Provides
    @ApiKeyInterceptor
    fun apiKeyInterceptor(): Interceptor = Interceptor { chain ->
        val original = chain.request()
        val newURL = original.url.newBuilder()
            .build()

        chain.proceed(
            original.newBuilder()
                .url(newURL)
                .build()
        )
    }

    @Provides
    @LoggingInterceptor
    fun provideLoggingInterceptor() : Interceptor {
        return HttpLoggingInterceptor()
            .setLevel(
                HttpLoggingInterceptor.Level.BODY
            )
    }

    @Provides
    fun okhttp(
        @ApiKeyInterceptor apiKeyInterceptor: Interceptor,
        @LoggingInterceptor httpLoggingInterceptor: Interceptor,
        ): OkHttpClient =
        OkHttpClient.Builder()
            .addInterceptor(apiKeyInterceptor)
            .also {
                if (BuildConfig.DEBUG) {
                    it.addInterceptor(
                        httpLoggingInterceptor
                    )
                }
            }
            .build()

    @Provides
    fun provideGsonConverter(): GsonConverterFactory = GsonConverterFactory.create()

    @Provides
    fun api(
        okHttpClient: OkHttpClient,
        gsonConverterFactory: GsonConverterFactory
    ): Api =
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .client(okHttpClient)
            .addConverterFactory(gsonConverterFactory)
            .build()
            .create(Api::class.java)

}

