package kpfu.itis.valisheva.android_app_2.presentation.rv

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.RequestManager
import kpfu.itis.valisheva.android_app_2.domain.entities.AnimeShortInfo
import javax.inject.Inject

class AnimeAdapter (
    private val list: List<AnimeShortInfo>,
    private val itemClick: (Int) -> (Unit),
    private val glide: RequestManager,
) : RecyclerView.Adapter<AnimeHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AnimeHolder {
        return AnimeHolder.create(parent, itemClick,glide)
    }

    override fun onBindViewHolder(holder: AnimeHolder, position: Int) {
        holder.bind(list[position])
    }

    override fun getItemCount(): Int = list.size

}
