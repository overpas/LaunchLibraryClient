package by.overpass.soraac.data.db.datasource.mission

import android.arch.lifecycle.LiveData
import by.overpass.soraac.SoraacApp
import by.overpass.soraac.data.db.AppDB
import by.overpass.soraac.data.model.pojo.db.Mission
import kotlinx.coroutines.experimental.CommonPool
import kotlinx.coroutines.experimental.launch

class LocalMissionDataSourceImpl : ILocalMissionDataSource {

    private val missionDao by lazy {
        return@lazy AppDB.getInstance(SoraacApp.getAppContext()).getMissionDao()
    }

    override fun getMissions(): LiveData<List<Mission>> = missionDao.selectAllOrderedByName()

    override fun addMissions(missions: List<Mission>) {
        launch(CommonPool) {
            missions.forEach { missionDao.insert(it) }
        }
    }

    override fun getMissionById(id: Int): LiveData<Mission> = missionDao.selectById(id)

}