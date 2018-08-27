package by.overpass.soraac.repository.launch

import android.arch.lifecycle.LiveData
import by.overpass.soraac.data.db.datasource.launch.ILocalLaunchDataSource
import by.overpass.soraac.data.model.pojo.db.Launch
import by.overpass.soraac.data.network.datasource.launch.IRemoteLaunchDataSource
import kotlinx.coroutines.experimental.CommonPool
import kotlinx.coroutines.experimental.launch

class LaunchRepositoryImpl(
        private val remoteLaunchDataSource: IRemoteLaunchDataSource,
        private val localLaunchDataSource: ILocalLaunchDataSource
) : ILaunchRepository {

    override fun getLaunches(): LiveData<List<Launch>> {
        launch(CommonPool) {
            localLaunchDataSource.addLaunches(remoteLaunchDataSource.getLaunches())
        }
        return localLaunchDataSource.getLaunches()
    }

}