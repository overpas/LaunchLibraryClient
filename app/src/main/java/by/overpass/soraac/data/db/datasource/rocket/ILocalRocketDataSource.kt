package by.overpass.soraac.data.db.datasource.rocket

import android.arch.lifecycle.LiveData
import by.overpass.soraac.data.model.pojo.db.Rocket

interface ILocalRocketDataSource {
    fun getRockets(): LiveData<List<Rocket>>
    fun addRockets(rockets: List<Rocket>)
    fun getRocketById(id: Int): LiveData<Rocket>
}