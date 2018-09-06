package by.overpass.soraac.viewmodel.mission

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.ViewModel
import by.overpass.soraac.data.db.datasource.mission.LocalMissionDataSourceImpl
import by.overpass.soraac.data.model.pojo.db.Mission
import by.overpass.soraac.data.network.datasource.mission.RemoteMissionDataSourceImpl
import by.overpass.soraac.repository.mission.IMissionRepository
import by.overpass.soraac.repository.mission.MissionRepositoryImpl

class MissionViewModel(
        internal var missionRepository: IMissionRepository = MissionRepositoryImpl(
                RemoteMissionDataSourceImpl(),
                LocalMissionDataSourceImpl()
        )
) : ViewModel() {

    fun getById(id: Int) = missionRepository.getById(id)

    val missions: LiveData<List<Mission>>
        get() = missionRepository.missions

}