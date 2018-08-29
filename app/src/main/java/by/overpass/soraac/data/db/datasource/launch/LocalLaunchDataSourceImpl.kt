package by.overpass.soraac.data.db.datasource.launch

import android.arch.lifecycle.LiveData
import android.util.Log
import by.overpass.soraac.SoraacApp
import by.overpass.soraac.data.db.AppDB
import by.overpass.soraac.data.model.pojo.db.Launch
import kotlinx.coroutines.experimental.CommonPool
import kotlinx.coroutines.experimental.launch

class LocalLaunchDataSourceImpl : ILocalLaunchDataSource {

    private val launchDao by lazy {
        return@lazy AppDB.getInstance(SoraacApp.getAppContext()).getLaunchDao()
    }

    override fun getLaunches(): LiveData<List<Launch>> {
        return launchDao.selectAllOrderedByStartTime().also {
            Log.d(this.javaClass.simpleName, "local launches: ${it.value}")
        }
    }

    override fun addLaunches(launches: List<Launch>) {
        launch(CommonPool) {
            Log.d(this.javaClass.simpleName, "adding launches: $launches " +
                    "in ${Thread.currentThread().name} thread")
            for (launch in launches) {
                launchDao.insert(launch)
            }
        }
    }

}