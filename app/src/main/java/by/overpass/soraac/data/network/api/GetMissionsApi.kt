package by.overpass.soraac.data.network.api

import by.overpass.soraac.data.model.pojo.api.MissionsJsonWrapper
import retrofit2.Call
import retrofit2.http.GET

interface GetMissionsApi {

    @GET("mission")
    fun getAllMissions(): Call<MissionsJsonWrapper>

}