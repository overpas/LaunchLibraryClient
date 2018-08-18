package by.overpass.soraac.data.model.pojo.api

import com.google.gson.annotations.SerializedName

data class PayloadInLaunch(
        @SerializedName("id") var id: Int?,
        @SerializedName("name") var name: String?
)