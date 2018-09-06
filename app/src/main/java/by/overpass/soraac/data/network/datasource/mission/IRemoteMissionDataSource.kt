package by.overpass.soraac.data.network.datasource.mission

import android.arch.lifecycle.LiveData
import by.overpass.soraac.data.model.pojo.db.Mission

interface IRemoteMissionDataSource {
    fun getMissions(): LiveData<List<Mission>>

}