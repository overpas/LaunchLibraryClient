package by.overpass.soraac.data.model.pojo.api

import com.google.gson.annotations.SerializedName

data class FamilyInRocket(
        @SerializedName("id") var id: Int?,
        @SerializedName("name") var name: String?,
        @SerializedName("agencies") var agencies: String?
)