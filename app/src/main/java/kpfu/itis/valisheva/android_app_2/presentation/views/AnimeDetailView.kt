package kpfu.itis.valisheva.android_app_2.presentation.views

import kpfu.itis.valisheva.android_app_2.domain.entities.AnimeFullInfo
import moxy.MvpView
import moxy.viewstate.strategy.alias.AddToEndSingle
import moxy.viewstate.strategy.alias.OneExecution
import moxy.viewstate.strategy.alias.Skip

@AddToEndSingle
interface AnimeDetailView : MvpView {

    @Skip
    fun showError(message: String)

    fun updateView(anime: AnimeFullInfo)

}
