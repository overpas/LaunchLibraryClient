package by.overpass.soraac.model.pojo.api

import com.google.gson.annotations.SerializedName

data class PadInLaunch(
        @SerializedName("id") var id: Int?,
        @SerializedName("name") var name: String?,
        @SerializedName("infoURL") var infoURL: String?,
        @SerializedName("wikiURL") var wikiURL: String?,
        @SerializedName("mapURL") var mapURL: String?,
        @SerializedName("latitude") var latitude: Double?,
        @SerializedName("longitude") var longitude: Double?,
        @SerializedName("agencies") var agencies: List<Any>?
)