package by.overpass.soraac.data.network.datasource.rocket

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import by.overpass.soraac.data.model.pojo.Conversion
import by.overpass.soraac.data.model.pojo.api.RocketsJsonWrapper
import by.overpass.soraac.data.model.pojo.db.Rocket
import by.overpass.soraac.data.network.api.GetRocketsApi
import by.overpass.soraac.data.network.retrofit
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class RemoteRocketDataSourceImpl : IRemoteRocketDataSource {

    private val rocketApi = retrofit.create(GetRocketsApi::class.java)

    override fun getRockets(): LiveData<List<Rocket>> {
        val rockets: MutableLiveData<List<Rocket>> = MutableLiveData()
        rocketApi.getAllRockets().enqueue(object : Callback<RocketsJsonWrapper> {
            override fun onFailure(call: Call<RocketsJsonWrapper>?, t: Throwable?) {
            }

            override fun onResponse(call: Call<RocketsJsonWrapper>?, response: Response<RocketsJsonWrapper>?) {
                response?.body()?.let {
                    rockets.value = Conversion.RocketConversion.fromApiToDB(it)
                }
            }
        })
        return rockets
    }
}