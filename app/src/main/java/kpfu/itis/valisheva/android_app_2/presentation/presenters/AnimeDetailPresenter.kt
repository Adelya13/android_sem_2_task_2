package kpfu.itis.valisheva.android_app_2.presentation.presenters

import io.reactivex.rxjava3.core.Scheduler
import io.reactivex.rxjava3.disposables.CompositeDisposable
import io.reactivex.rxjava3.kotlin.plusAssign
import io.reactivex.rxjava3.kotlin.subscribeBy
import kpfu.itis.valisheva.android_app_2.di.qualifiers.SchedulerUIInterceptor
import kpfu.itis.valisheva.android_app_2.domain.usecases.GetAnimeByIdUseCase
import kpfu.itis.valisheva.android_app_2.presentation.views.AnimeDetailView
import kpfu.itis.valisheva.android_app_2.presentation.views.AnimeListView
import moxy.MvpPresenter
import retrofit2.HttpException
import javax.inject.Inject

class AnimeDetailPresenter @Inject constructor(
    private val getAnimeByIdUseCase: GetAnimeByIdUseCase,
    @SchedulerUIInterceptor private val scheduler: Scheduler,
): MvpPresenter<AnimeDetailView>(){

    private val disposables = CompositeDisposable()


    fun getAnimeById(id: Int) {
        disposables += getAnimeByIdUseCase(id)
            .observeOn(scheduler)
            .subscribeBy(onSuccess = {
                viewState.updateView(it)
            }, onError = { error ->
                when (error) {
                    HttpException::class -> viewState.showError("Anime information doesn't upload")
                    else -> viewState.showError("Try again.")
                }
            })
    }


    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
    }

    override fun attachView(view: AnimeDetailView?) {
        super.attachView(view)
    }

    override fun detachView(view: AnimeDetailView?) {
        super.detachView(view)
    }

    override fun onDestroy() {
        disposables.dispose()
        super.onDestroy()
    }

}
