package by.overpass.soraac.data.network.datasource

import android.arch.lifecycle.LiveData
import by.overpass.soraac.model.pojo.db.Launch

interface ILaunchDataSource {
    fun getLaunches(): LiveData<List<Launch>>
}