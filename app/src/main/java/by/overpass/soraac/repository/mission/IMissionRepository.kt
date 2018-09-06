package by.overpass.soraac.repository.mission

import android.arch.lifecycle.LiveData
import by.overpass.soraac.data.model.pojo.db.Mission

interface IMissionRepository {
    fun getById(id: Int): LiveData<Mission>

    val missions: LiveData<List<Mission>>
}