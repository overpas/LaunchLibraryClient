package by.overpass.soraac.data.model.pojo.api

import com.google.gson.annotations.SerializedName

data class RocketsJsonWrapper(
        @SerializedName("rockets") var rockets: List<Rocket?>?,
        @SerializedName("total") var total: Int?,
        @SerializedName("count") var count: Int?,
        @SerializedName("offset") var offset: Int?
)