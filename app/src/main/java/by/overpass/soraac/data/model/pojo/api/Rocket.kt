package by.overpass.soraac.data.model.pojo.api

import com.google.gson.annotations.SerializedName

data class Rocket(
        @SerializedName("id") var id: Int?,
        @SerializedName("name") var name: String?,
        @SerializedName("configuration") var configuration: String?,
        @SerializedName("defaultPads") var defaultPads: String?,
        @SerializedName("family") var family: FamilyInRocket?,
        @SerializedName("infoURL") var infoURL: Any?,
        @SerializedName("wikiURL") var wikiURL: String?,
        @SerializedName("infoURLs") var infoURLs: List<String?>?,
        @SerializedName("imageSizes") var imageSizes: List<Int?>?,
        @SerializedName("imageURL") var imageURL: String?,
        @SerializedName("changed") var changed: String?
)