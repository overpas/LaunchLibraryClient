package by.overpass.soraac.data.model.pojo.api

import com.google.gson.annotations.SerializedName

data class MissionsJsonWrapper(
        @SerializedName("missions") var compactMissions: List<CompactMission?>?,
        @SerializedName("total") var total: Int?,
        @SerializedName("count") var count: Int?,
        @SerializedName("offset") var offset: Int?
)