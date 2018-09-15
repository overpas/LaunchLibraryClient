package by.overpass.soraac.data.network.datasource.launch

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import by.overpass.soraac.data.model.pojo.Conversion
import by.overpass.soraac.data.model.pojo.api.LaunchJsonWrapper
import by.overpass.soraac.data.model.pojo.db.Launch
import by.overpass.soraac.data.network.api.GetLaunchesApi
import by.overpass.soraac.data.network.retrofit
import by.overpass.soraac.data.network.status.Status
import by.overpass.soraac.data.network.status.StatusLiveData
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class RemoteLaunchDataSourceImpl : IRemoteLaunchDataSource {

    private val launchService = retrofit.create(GetLaunchesApi::class.java)

    override fun getLaunches(): LiveData<List<Launch>> {
        val launches: MutableLiveData<List<Launch>> = MutableLiveData()
        StatusLiveData.value = Status.LOADING
        launchService.getNext20Launches().enqueue(object : Callback<LaunchJsonWrapper> {
            override fun onFailure(call: Call<LaunchJsonWrapper>?, t: Throwable?) {
                StatusLiveData.value = Status.ERROR
            }

            override fun onResponse(call: Call<LaunchJsonWrapper>?, response: Response<LaunchJsonWrapper>?) {
                response?.body()?.let {
                    launches.value = Conversion.LaunchConversion.fromApiToDB(it)
                    StatusLiveData.value = Status.LOADED
                }
            }
        })
        return launches
    }

}