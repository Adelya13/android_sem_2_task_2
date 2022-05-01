package kpfu.itis.valisheva.android_app_2.presentation.views

import kpfu.itis.valisheva.android_app_2.domain.entities.AnimeShortInfo
import moxy.MvpView
import moxy.viewstate.strategy.alias.AddToEndSingle
import moxy.viewstate.strategy.alias.OneExecution
import moxy.viewstate.strategy.alias.Skip


@AddToEndSingle
interface AnimeListView :MvpView {

    fun updateList(list: MutableList<AnimeShortInfo>)

    @Skip
    fun showError(message: String)

    @OneExecution
    fun openInformation(id: Int)

    fun showLoading()

    fun hideLoading()
}
