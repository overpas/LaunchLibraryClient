package by.overpass.soraac.data.model.pojo.api

import com.google.gson.annotations.SerializedName

data class Mission(
        @SerializedName("id") var id: Int?,
        @SerializedName("name") var name: String?,
        @SerializedName("description") var description: String?,
        @SerializedName("agencies") var agencies: List<AgencyInMission?>?,
        @SerializedName("type") var type: Int?,
        @SerializedName("typeName") var typeName: String?,
        @SerializedName("launch") var launch: LaunchInMission?,
        @SerializedName("infoURL") var infoURL: String?,
        @SerializedName("wikiURL") var wikiURL: String?,
        @SerializedName("events") var events: Any?,
        @SerializedName("infoURLs") var infoURLs: List<Any?>?,
        @SerializedName("changed") var changed: String?,
        @SerializedName("payloads") var payloads: List<Any?>?
)