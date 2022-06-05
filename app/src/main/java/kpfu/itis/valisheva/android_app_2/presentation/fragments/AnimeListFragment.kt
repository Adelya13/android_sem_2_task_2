package kpfu.itis.valisheva.android_app_2.presentation.fragments

import android.os.Bundle
import android.view.View
import android.widget.SearchView
import androidx.navigation.NavOptions
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.google.android.material.snackbar.Snackbar
import dagger.hilt.android.AndroidEntryPoint
import kpfu.itis.valisheva.android_app_2.R
import kpfu.itis.valisheva.android_app_2.databinding.FragmentAnimeListBinding
import kpfu.itis.valisheva.android_app_2.domain.entities.AnimeShortInfo
import kpfu.itis.valisheva.android_app_2.presentation.decorators.SpaceItemDecorator
import kpfu.itis.valisheva.android_app_2.presentation.presenters.AnimeListPresenter
import kpfu.itis.valisheva.android_app_2.presentation.rv.AnimeAdapter
import kpfu.itis.valisheva.android_app_2.presentation.views.AnimeListView
import moxy.MvpAppCompatFragment
import moxy.presenter.InjectPresenter
import moxy.presenter.ProvidePresenter
import javax.inject.Inject



private const val KEY_ANIME_ID = "Anime"

@AndroidEntryPoint
class AnimeListFragment: MvpAppCompatFragment(R.layout.fragment_anime_list), AnimeListView {

    private lateinit var binding: FragmentAnimeListBinding
    private lateinit var animeAdapter: AnimeAdapter

    @Inject
    @InjectPresenter
    lateinit var presenter: AnimeListPresenter

    @ProvidePresenter
    fun providePresenter(): AnimeListPresenter = presenter


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentAnimeListBinding.bind(view)
        initSV()
        initRV()
        presenter.getTopAnimeList()
    }

    override fun updateList(list: MutableList<AnimeShortInfo>) {
        if (list.size > 0) {
            updateAdapter(list)
            showList()
        } else hideList()
    }

    override fun showError(message: String) {
        showMessage(message)
    }

    override fun openInformation(id: Int) {
        openAnimeInfo(id)
    }

    override fun showLoading() {
        binding.progress.visibility = View.VISIBLE
    }

    override fun hideLoading() {
        binding.progress.visibility = View.GONE
    }

    private fun openDetails(id: Int) {
        presenter.getAnimeById(id)
    }

    private fun updateAdapter(animeList: MutableList<AnimeShortInfo>){
        animeAdapter = AnimeAdapter(
            animeList,
            {openAnimeInfo(it)},
            Glide.with(this)
        )
        binding.rvAnime.apply{
            adapter = animeAdapter
        }

    }

    private fun initRV(){
        val decorator = DividerItemDecoration(requireContext(), RecyclerView.VERTICAL)
        val spacing = SpaceItemDecorator(requireContext())
        binding.rvAnime.run{
            addItemDecoration(decorator)
            addItemDecoration(spacing)
        }
    }
    private fun initSV(){
        with(binding){
            svSearchAnime.setOnQueryTextListener(object: SearchView.OnQueryTextListener{
                override fun onQueryTextSubmit(query: String?): Boolean {
                    presenter.getAnimeList(query?.trim().toString())
                    return false
                }
                override fun onQueryTextChange(newText: String?): Boolean {
                    return false
                }
            })
        }
    }

    private fun openAnimeInfo(animeId: Int?){
        var bundle: Bundle? = null
        animeId?.let {
            bundle = Bundle().apply {
                putInt(KEY_ANIME_ID, animeId)
            }
        }
        val options = NavOptions.Builder()
            .setLaunchSingleTop(true)
            .build()

        findNavController().navigate(
            R.id.action_animeListFragment_to_animeInformationFragment,
            bundle,
            options
        )

    }

    private fun hideList() {
        with(binding) {
            rvAnime.visibility = View.INVISIBLE
            showMessage("Not found anime")
        }
    }
    private fun showList() {
        with(binding) {
            rvAnime.visibility = View.VISIBLE
        }
    }

    private fun showMessage(message: String) {
        Snackbar.make(
            requireActivity().findViewById(R.id.container),
            message,
            Snackbar.LENGTH_LONG
        ).show()
    }

    override fun onDestroyView() {
        super.onDestroyView()
    }
}
