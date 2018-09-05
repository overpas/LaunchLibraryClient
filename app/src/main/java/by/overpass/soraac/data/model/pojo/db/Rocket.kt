package by.overpass.soraac.data.model.pojo.db

import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey
import android.databinding.BindingAdapter
import android.widget.ImageView
import com.bumptech.glide.Glide

@Entity
data class Rocket(
        @PrimaryKey
        var id: Int?,
        var name: String?,
        var infoURL: String?,
        var wikiURL: String?,
        var imageURL: String?
) {
    companion object {
        @JvmStatic
        @BindingAdapter("android:src")
        fun loadImage(view: ImageView, imageUrl: String) {
            Glide
                    .with(view.context)
                    .load(imageUrl)
                    .into(view)
        }
    }
}