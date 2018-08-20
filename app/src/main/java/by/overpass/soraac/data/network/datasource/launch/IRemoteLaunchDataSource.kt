package by.overpass.soraac.data.network.datasource.launch

import android.arch.lifecycle.LiveData
import by.overpass.soraac.data.model.pojo.db.Launch

interface IRemoteLaunchDataSource {
    fun getLaunches(): LiveData<List<Launch>>
}