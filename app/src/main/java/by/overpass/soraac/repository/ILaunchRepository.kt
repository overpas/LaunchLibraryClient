package by.overpass.soraac.repository

import android.arch.lifecycle.LiveData
import by.overpass.soraac.model.pojo.db.Launch

interface ILaunchRepository {
    fun getLaunches(): LiveData<List<Launch>>
}