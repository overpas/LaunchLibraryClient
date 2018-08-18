package by.overpass.soraac.data.model.pojo.api

import com.google.gson.annotations.SerializedName

data class MissionInLaunch(
        @SerializedName("id") var id: Int?,
        @SerializedName("name") var name: String?,
        @SerializedName("description") var description: String?,
        @SerializedName("type") var type: Int?,
        @SerializedName("wikiURL") var wikiURL: String?,
        @SerializedName("typeName") var typeName: String?,
        @SerializedName("agencies") var agencies: List<AgencyInLaunch>?,
        @SerializedName("payloads") var payloads: List<PayloadInLaunch>?
)