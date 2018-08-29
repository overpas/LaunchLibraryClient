package by.overpass.soraac.repository.launch

import android.arch.lifecycle.LiveData
import android.util.Log
import by.overpass.soraac.SoraacApp
import by.overpass.soraac.data.db.AppDB
import by.overpass.soraac.data.db.datasource.launch.ILocalLaunchDataSource
import by.overpass.soraac.data.model.pojo.db.Launch
import by.overpass.soraac.data.network.datasource.launch.IRemoteLaunchDataSource

class LaunchRepositoryImpl(
        private val remoteLaunchDataSource: IRemoteLaunchDataSource,
        private val localLaunchDataSource: ILocalLaunchDataSource
) : ILaunchRepository {

    private val launchDao by lazy {
        return@lazy AppDB.getInstance(SoraacApp.getAppContext()).getLaunchDao()
    }

    override val launches: LiveData<List<Launch>>
        get() {
            Log.i(this.javaClass.simpleName, ": putting launches from remote DS to local DS " +
                    "in ${Thread.currentThread().name} thread")
            remoteLaunchDataSource.getLaunches().observeForever({ list ->
                list?.let { localLaunchDataSource.addLaunches(it) }
            })
            Log.i(this.javaClass.simpleName, ": returning local launches")
            return launchDao.selectAllOrderedByStartTime()
        }

}