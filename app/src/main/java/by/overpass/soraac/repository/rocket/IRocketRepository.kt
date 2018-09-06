package by.overpass.soraac.repository.rocket

import android.arch.lifecycle.LiveData
import by.overpass.soraac.data.model.pojo.db.Rocket

interface IRocketRepository {
    fun getById(id: Int): LiveData<Rocket>

    val rockets: LiveData<List<Rocket>>
}