package kpfu.itis.valisheva.android_app_2.presentation.fragments

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import com.bumptech.glide.Glide
import com.google.android.material.snackbar.Snackbar
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch
import kpfu.itis.valisheva.android_app_2.R
import kpfu.itis.valisheva.android_app_2.databinding.FragmentAnimeInformationBinding
import kpfu.itis.valisheva.android_app_2.domain.entities.AnimeFullInfo
import kpfu.itis.valisheva.android_app_2.presentation.presenters.AnimeDetailPresenter
import kpfu.itis.valisheva.android_app_2.presentation.views.AnimeDetailView
import moxy.MvpAppCompatFragment
import moxy.presenter.InjectPresenter
import moxy.presenter.ProvidePresenter
import java.lang.StringBuilder
import javax.inject.Inject

private const val KEY_ANIME_ID = "Anime"

@AndroidEntryPoint
class AnimeInformationFragment: MvpAppCompatFragment(R.layout.fragment_anime_information), AnimeDetailView {

    private lateinit var binding: FragmentAnimeInformationBinding
    private val animeId: Int by lazy {
        arguments?.getInt(KEY_ANIME_ID) ?: -1
    }

    @Inject
    @InjectPresenter
    lateinit var presenter: AnimeDetailPresenter

    @ProvidePresenter
    fun providePresenter(): AnimeDetailPresenter = presenter


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentAnimeInformationBinding.bind(view)
        updateUI(animeId)
    }

    override fun showError(message: String) {
        showMessage(message)
    }

    override fun updateView(anime: AnimeFullInfo) {
        with(binding) {
            tvAnimeName.text = anime.title
            tvStatus.text = anime.status
            tvGenres.text = convertGenre(anime.genres)
            tvRating.text = anime.rating
            downloadImg(anime.imagePath)

        }
    }

    private fun updateUI(id: Int) {
        presenter.getAnimeById(id)
    }

    private fun downloadImg(animeImg: String){
        Glide.with(this).load(
            animeImg
        ).into(binding.ivAnime)

    }
    private fun convertGenre(genres: MutableList<String>) : String{
        val stringBuilder: StringBuilder = StringBuilder()
        genres.forEach {
            stringBuilder.append("$it | ")
        }
        stringBuilder.setLength(stringBuilder.length - 3)
        return stringBuilder.toString()
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
