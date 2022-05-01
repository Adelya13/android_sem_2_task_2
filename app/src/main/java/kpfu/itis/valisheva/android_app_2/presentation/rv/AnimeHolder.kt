package kpfu.itis.valisheva.android_app_2.presentation.rv

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.RequestManager
import com.google.gson.Gson
import kotlinx.coroutines.launch
import kpfu.itis.valisheva.android_app_2.databinding.ItemAnimeBinding
import kpfu.itis.valisheva.android_app_2.domain.entities.AnimeShortInfo

class AnimeHolder(
    private val binding: ItemAnimeBinding,
    private val action: (Int) -> Unit,
    private val glide: RequestManager,
): RecyclerView.ViewHolder(binding.root){


    fun bind(item: AnimeShortInfo) {
        with(binding) {

            tvName.text = item.title
            tvScore.text = item.score.toString()
            glide.load(item.imagePath).into(ivAnime)
            ivAnime
        }
        itemView.setOnClickListener {
            action(item.id)
        }
    }
    companion object {
        fun create(
            parent: ViewGroup,
            action: (Int) -> Unit,
            glide: RequestManager
        ) = AnimeHolder(
            ItemAnimeBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            ),
            action,
            glide,
        )
    }

}
