package by.overpass.soraac.data.model.pojo.db

import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey

@Entity
data class Mission(
        @PrimaryKey
        var id: Int?,
        var name: String?,
        var description: String?,
        var infoURL: String?,
        var wikiURL: String?
)