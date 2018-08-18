package by.overpass.soraac.data.model.pojo.api

import com.google.gson.annotations.SerializedName

data class LaunchJsonWrapper(
        @SerializedName("launches") var launches: List<Launch>,
        @SerializedName("total") var total: Int,
        @SerializedName("offset") var offset: Int,
        @SerializedName("count") var count: Int
)