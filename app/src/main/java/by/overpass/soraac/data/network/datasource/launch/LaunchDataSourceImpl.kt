package by.overpass.soraac.data.network.datasource.launch

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import by.overpass.soraac.data.model.pojo.Conversion
import by.overpass.soraac.data.model.pojo.api.LaunchJsonWrapper
import by.overpass.soraac.data.model.pojo.db.Launch
import by.overpass.soraac.data.network.GetLaunchesService
import by.overpass.soraac.data.network.retrofit
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class LaunchDataSourceImpl : ILaunchDataSource {

    private val launchService = retrofit.create(GetLaunchesService::class.java)

    override fun getLaunches(): LiveData<List<Launch>> {
        val launches: MutableLiveData<List<Launch>> = MutableLiveData()
        launchService.getNext20Launches().enqueue(object : Callback<LaunchJsonWrapper> {
            override fun onFailure(call: Call<LaunchJsonWrapper>?, t: Throwable?) {
            }

            override fun onResponse(call: Call<LaunchJsonWrapper>?, response: Response<LaunchJsonWrapper>?) {
                response?.body()?.let {
                    launches.value = Conversion.LaunchConversion.fromApiToDB(it)
                }
            }
        })
        return launches
    }

}