package by.overpass.soraac.data.network

import by.overpass.soraac.data.model.pojo.api.LaunchJsonWrapper
import retrofit2.Call
import retrofit2.http.GET


interface GetLaunchesService {

    @GET("launch/next/5")
    fun getNext5Launches(): Call<LaunchJsonWrapper>

    @GET("launch/next/20")
    fun getNext20Launches(): Call<LaunchJsonWrapper>

}