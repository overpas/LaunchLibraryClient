package by.overpass.soraac.data.model.pojo.api

import com.google.gson.annotations.SerializedName

data class LaunchInMission(
        @SerializedName("id") var id: Int?,
        @SerializedName("name") var name: String?,
        @SerializedName("windowstart") var windowstart: String?,
        @SerializedName("windowend") var windowend: String?,
        @SerializedName("net") var net: String?
)