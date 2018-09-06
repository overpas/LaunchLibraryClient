package by.overpass.soraac.repository.mission

import android.arch.lifecycle.LiveData
import by.overpass.soraac.data.db.datasource.mission.ILocalMissionDataSource
import by.overpass.soraac.data.model.pojo.db.Mission
import by.overpass.soraac.data.network.datasource.mission.IRemoteMissionDataSource

class MissionRepositoryImpl(
        private val remoteDataSource: IRemoteMissionDataSource,
        private val localDataSource: ILocalMissionDataSource
) : IMissionRepository {

    override fun getById(id: Int): LiveData<Mission> = localDataSource.getMissionById(id)

    override val missions: LiveData<List<Mission>>
        get() {
            remoteDataSource.getMissions().observeForever { list ->
                list?.let { localDataSource.addMissions(it) }
            }
            return localDataSource.getMissions()
        }

}