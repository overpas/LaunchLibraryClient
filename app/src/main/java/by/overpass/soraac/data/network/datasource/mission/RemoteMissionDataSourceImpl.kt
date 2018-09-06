package by.overpass.soraac.data.network.datasource.mission

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import by.overpass.soraac.data.model.pojo.Conversion
import by.overpass.soraac.data.model.pojo.api.MissionsJsonWrapper
import by.overpass.soraac.data.model.pojo.db.Mission
import by.overpass.soraac.data.network.api.GetMissionsApi
import by.overpass.soraac.data.network.retrofit
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class RemoteMissionDataSourceImpl : IRemoteMissionDataSource {

    private val missionApi = retrofit.create(GetMissionsApi::class.java)

    override fun getMissions(): LiveData<List<Mission>> {
        val missions: MutableLiveData<List<Mission>> = MutableLiveData()
        missionApi.getAllMissions().enqueue(object : Callback<MissionsJsonWrapper> {
            override fun onFailure(call: Call<MissionsJsonWrapper>?, t: Throwable?) {
            }

            override fun onResponse(call: Call<MissionsJsonWrapper>?, response: Response<MissionsJsonWrapper>?) {
                response?.body()?.let {
                    missions.value = Conversion.MissionConversion.fromApiToDB(it)
                }
            }
        })
        return missions
    }
}