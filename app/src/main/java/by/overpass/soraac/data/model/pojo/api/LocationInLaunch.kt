package by.overpass.soraac.data.model.pojo.api

import com.google.gson.annotations.SerializedName

data class LocationInLaunch(
        @SerializedName("pads") var pads: List<PadInLaunch>?,
        @SerializedName("id") var id: Int?,
        @SerializedName("name") var name: String?,
        @SerializedName("infoURL") var infoURL: String?,
        @SerializedName("wikiURL") var wikiURL: String?,
        @SerializedName("countryCode") var countryCode: String?
)