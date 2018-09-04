package by.overpass.soraac.data.db.datasource.rocket

import android.arch.lifecycle.LiveData
import by.overpass.soraac.SoraacApp
import by.overpass.soraac.data.db.AppDB
import by.overpass.soraac.data.model.pojo.db.Rocket
import kotlinx.coroutines.experimental.CommonPool
import kotlinx.coroutines.experimental.launch

class LocalRocketDataSourceImpl : ILocalRocketDataSource {

    private val rocketDao by lazy {
        return@lazy AppDB.getInstance(SoraacApp.getAppContext()).getRocketDao()
    }

    override fun getRockets(): LiveData<List<Rocket>> {
        return rocketDao.selectAllOrderedByName()
    }

    override fun addRockets(rockets: List<Rocket>) {
        launch(CommonPool) {
            rockets.forEach { rocketDao.insert(it) }
        }
    }

    override fun getRocketById(id: Int): LiveData<Rocket> {
        return rocketDao.selectById(id)
    }
}