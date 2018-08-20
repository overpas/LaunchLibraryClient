package by.overpass.soraac.repository.launch

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import android.util.Log
import by.overpass.soraac.data.db.datasource.launch.ILocalLaunchDataSource
import by.overpass.soraac.data.model.pojo.db.Launch
import by.overpass.soraac.data.network.datasource.launch.IRemoteLaunchDataSource

class LaunchRepositoryImpl(
        private val remoteLaunchDataSource: IRemoteLaunchDataSource,
        private val localLaunchDataSource: ILocalLaunchDataSource) : ILaunchRepository {

    private var cachedLaunches: LiveData<List<Launch>>? = null

    override fun getLaunches(): LiveData<List<Launch>> {
        if (cachedLaunches == null) {
            Log.d(this::class.java.simpleName, "NOT CACHED")
            cachedLaunches = remoteLaunchDataSource.getLaunches()
        } else {
            Log.d(this::class.java.simpleName, "CACHED")
        }
        return cachedLaunches ?: MutableLiveData()
    }

}