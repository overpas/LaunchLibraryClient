package by.overpass.soraac.data.db.datasource.launch

import android.arch.lifecycle.LiveData
import android.util.Log
import by.overpass.soraac.SoraacApp
import by.overpass.soraac.data.db.AppDB
import by.overpass.soraac.data.model.pojo.db.Launch

class LocalLaunchDataSourceImpl : ILocalLaunchDataSource {

    private val launchDao by lazy {
        return@lazy AppDB.getInstance(SoraacApp.getAppContext()).getLaunchDao()
    }

    override fun getLaunches(): LiveData<List<Launch>> = launchDao.selectAllOrderedByStartTime()

    override fun addLaunches(launches: List<Launch>) {
        Log.d(this.javaClass.simpleName, "adding launches: $launches")
        launchDao.insert(launches)
    }

}