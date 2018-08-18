package by.overpass.soraac.repository.launch

import android.arch.lifecycle.LiveData
import by.overpass.soraac.data.model.pojo.db.Launch

interface ILaunchRepository {
    fun getLaunches(): LiveData<List<Launch>>
}