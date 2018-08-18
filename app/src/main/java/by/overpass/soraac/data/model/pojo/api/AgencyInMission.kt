package by.overpass.soraac.data.model.pojo.api

import com.google.gson.annotations.SerializedName

data class AgencyInMission(
        @SerializedName("id") var id: Int?,
        @SerializedName("name") var name: String?,
        @SerializedName("abbrev") var abbrev: String?,
        @SerializedName("countryCode") var countryCode: String?,
        @SerializedName("type") var type: Int?,
        @SerializedName("infoURL") var infoURL: String?,
        @SerializedName("wikiURL") var wikiURL: String?,
        @SerializedName("infoURLs") var infoURLs: List<Any?>?
)