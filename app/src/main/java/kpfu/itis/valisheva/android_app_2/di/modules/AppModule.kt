package kpfu.itis.valisheva.android_app_2.di.modules

import android.content.Context
import com.google.android.gms.location.FusedLocationProviderClient
import com.google.android.gms.location.LocationServices
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.core.Scheduler
import io.reactivex.rxjava3.schedulers.Schedulers
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kpfu.itis.valisheva.android_app_2.di.qualifiers.SchedulerIOInterceptor
import kpfu.itis.valisheva.android_app_2.di.qualifiers.SchedulerUIInterceptor

@Module
@InstallIn(SingletonComponent::class)
class AppModule {

    @Provides
    @SchedulerIOInterceptor
    fun provideAsyncScheduler(): Scheduler = Schedulers.io()

    @Provides
    @SchedulerUIInterceptor
    fun provideUiScheduler(): Scheduler = AndroidSchedulers.mainThread()

}
