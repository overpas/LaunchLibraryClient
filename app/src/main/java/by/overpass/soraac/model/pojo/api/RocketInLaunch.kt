package by.overpass.soraac.model.pojo.api

import com.google.gson.annotations.SerializedName

data class RocketInLaunch(
        @SerializedName("id") var id: Int?,
        @SerializedName("name") var name: String?,
        @SerializedName("configuration") var configuration: String?,
        @SerializedName("familyname") var familyname: String?,
        @SerializedName("agencies") var agencies: List<Any>?,
        @SerializedName("wikiURL") var wikiURL: String?,
        @SerializedName("infoURLs") var infoURLs: List<Any>?,
        @SerializedName("imageSizes") var imageSizes: List<Int>?,
        @SerializedName("imageURL") var imageURL: String?
)