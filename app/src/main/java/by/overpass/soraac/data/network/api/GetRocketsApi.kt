package by.overpass.soraac.data.network.api

import by.overpass.soraac.data.model.pojo.api.RocketsJsonWrapper
import retrofit2.Call
import retrofit2.http.GET

interface GetRocketsApi {

    @GET("rocket")
    fun getAllRockets(): Call<RocketsJsonWrapper>

}