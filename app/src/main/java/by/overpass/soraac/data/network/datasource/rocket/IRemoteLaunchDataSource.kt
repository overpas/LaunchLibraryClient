package by.overpass.soraac.data.network.datasource.rocket

import android.arch.lifecycle.LiveData
import by.overpass.soraac.data.model.pojo.db.Rocket

interface IRemoteRocketDataSource {
    fun getRockets(): LiveData<List<Rocket>>
}