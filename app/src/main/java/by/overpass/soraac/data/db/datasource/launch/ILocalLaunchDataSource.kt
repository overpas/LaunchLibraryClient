package by.overpass.soraac.data.db.datasource.launch

import android.arch.lifecycle.LiveData
import by.overpass.soraac.data.model.pojo.db.Launch

interface ILocalLaunchDataSource {
    fun getLaunches(): LiveData<List<Launch>>
    fun addLaunches(launches: List<Launch>)
    fun getLaunchById(id: Int): LiveData<Launch>
}