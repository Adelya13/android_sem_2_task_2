package kpfu.itis.valisheva.android_app_2.presentation.presenters


import io.reactivex.rxjava3.core.Scheduler
import io.reactivex.rxjava3.disposables.CompositeDisposable
import io.reactivex.rxjava3.kotlin.plusAssign
import io.reactivex.rxjava3.kotlin.subscribeBy
import kpfu.itis.valisheva.android_app_2.di.qualifiers.SchedulerUIInterceptor
import kpfu.itis.valisheva.android_app_2.domain.usecases.GetAnimeByIdUseCase
import kpfu.itis.valisheva.android_app_2.domain.usecases.GetAnimeByNameUseCase
import kpfu.itis.valisheva.android_app_2.domain.usecases.GetTopAnimeUseCase
import kpfu.itis.valisheva.android_app_2.presentation.views.AnimeListView
import moxy.MvpPresenter
import retrofit2.HttpException
import javax.inject.Inject

class AnimeListPresenter @Inject constructor(
    private val getAnimeByNameUseCase: GetAnimeByNameUseCase,
    private val getTopAnimeUseCase: GetTopAnimeUseCase,
    private val getAnimeByIdUseCase: GetAnimeByIdUseCase,
    @SchedulerUIInterceptor private val scheduler: Scheduler,
) : MvpPresenter<AnimeListView>() {

    private val disposables = CompositeDisposable()

    fun getAnimeList(name: String) {
        disposables += getAnimeByNameUseCase(name)
            .observeOn(scheduler)
            .doOnSubscribe {
                viewState.showLoading()
            }
            .doAfterTerminate {
                viewState.hideLoading()
            }
            .subscribeBy(onSuccess = { list ->
                viewState.updateList(list)
            }, onError = { error ->
                when (error) {
                    HttpException::class -> viewState.showError("List of Anime doesn't upload")
                    else -> viewState.showError("Try again.")
                }
            })
    }

    fun getTopAnimeList() {
        disposables += getTopAnimeUseCase()
            .observeOn(scheduler)
            .doOnSubscribe {
                viewState.showLoading()
            }
            .doAfterTerminate {
                viewState.hideLoading()
            }
            .subscribeBy(onSuccess = { list ->
                viewState.updateList(list)
            }, onError = { error ->
                when (error) {
                    HttpException::class -> viewState.showError("List of Anime doesn't upload")
                    else -> viewState.showError("Try again.")
                }
            })
    }

    fun getAnimeById(id: Int) {
        disposables += getAnimeByIdUseCase(id)
            .observeOn(scheduler)
            .subscribeBy(onSuccess = {
                viewState.openInformation(id)
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

    override fun attachView(view: AnimeListView?) {
        super.attachView(view)
    }

    override fun detachView(view: AnimeListView?) {
        super.detachView(view)
    }

    override fun onDestroy() {
        disposables.dispose()
        super.onDestroy()
    }

}
