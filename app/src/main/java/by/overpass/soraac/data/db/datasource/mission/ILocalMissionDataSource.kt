package by.overpass.soraac.data.db.datasource.mission

import android.arch.lifecycle.LiveData
import by.overpass.soraac.data.model.pojo.db.Mission

interface ILocalMissionDataSource {
    fun getMissions(): LiveData<List<Mission>>
    fun addMissions(Missions: List<Mission>)
    fun getMissionById(id: Int): LiveData<Mission>
}