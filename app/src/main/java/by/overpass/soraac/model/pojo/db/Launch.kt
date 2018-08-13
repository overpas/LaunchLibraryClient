package by.overpass.soraac.model.pojo.db

import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey
import android.databinding.BindingAdapter
import android.widget.ImageView
import com.bumptech.glide.Glide

@Entity
data class Launch(
        @PrimaryKey var id: Int?,
        var name: String?,
        var startStamp: Long?,
        var endStamp: Long?,
        var netStamp: Long?,
        var locationName: String?,
        var rocketImageURL: String?,
        var description: String?
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