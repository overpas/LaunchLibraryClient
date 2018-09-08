package by.overpass.soraac.viewmodel.mission

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProviders
import android.support.v4.app.Fragment
import by.overpass.soraac.data.db.datasource.mission.LocalMissionDataSourceImpl
import by.overpass.soraac.data.model.pojo.db.Mission
import by.overpass.soraac.data.network.datasource.mission.RemoteMissionDataSourceImpl
import by.overpass.soraac.repository.mission.IMissionRepository
import by.overpass.soraac.repository.mission.MissionRepositoryImpl
import by.overpass.soraac.viewmodel.ViewModelFactory

class MissionViewModel(
        private var missionRepository: IMissionRepository = MissionRepositoryImpl(
                RemoteMissionDataSourceImpl(),
                LocalMissionDataSourceImpl()
        )
) : ViewModel() {

    fun getById(id: Int) = missionRepository.getById(id)

    val missions: LiveData<List<Mission>>
        get() = missionRepository.missions

    object Factory : ViewModelFactory() {
        override fun get(fragment: Fragment) = ViewModelProviders
                .of(fragment)
                .get(MissionViewModel::class.java)
                .also {
                    it.missionRepository = MissionRepositoryImpl(
                            RemoteMissionDataSourceImpl(),
                            LocalMissionDataSourceImpl()
                    )
                }
    }

}