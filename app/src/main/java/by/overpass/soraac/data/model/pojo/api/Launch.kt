package by.overpass.soraac.data.model.pojo.api

import com.google.gson.annotations.SerializedName

data class Launch(
        @SerializedName("id") var id: Int?,
        @SerializedName("name") var name: String?,
        @SerializedName("windowstart") var windowstart: String?,
        @SerializedName("windowend") var windowend: String?,
        @SerializedName("net") var net: String,
        @SerializedName("wsstamp") var wsstamp: Long?,
        @SerializedName("westamp") var westamp: Long?,
        @SerializedName("netstamp") var netstamp: Long?,
        @SerializedName("isostart") var isostart: String?,
        @SerializedName("isoend") var isoend: String?,
        @SerializedName("isonet") var isonet: String?,
        @SerializedName("status") var status: Int?,
        @SerializedName("inhold") var inhold: Int?,
        @SerializedName("tbdtime") var tbdtime: Int?,
        @SerializedName("vidURLs") var vidURLs: List<String>?,
        @SerializedName("vidURL") var vidURL: Any?,
        @SerializedName("infoURLs") var infoURLs: List<String>?,
        @SerializedName("infoURL") var infoURL: Any?,
        @SerializedName("holdreason") var holdreason: String?,
        @SerializedName("failreason") var failreason: Any?,
        @SerializedName("tbddate") var tbddate: Int?,
        @SerializedName("probability") var probability: Int?,
        @SerializedName("hashtag") var hashtag: String?,
        @SerializedName("changed") var changed: String?,
        @SerializedName("location") var location: LocationInLaunch?,
        @SerializedName("rocket") var rocket: RocketInLaunch?,
        @SerializedName("missions") var missions: List<MissionInLaunch>?,
        @SerializedName("lsp") var lsp: LspInLaunch?
)