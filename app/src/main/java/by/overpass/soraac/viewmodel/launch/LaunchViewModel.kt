package by.overpass.soraac.viewmodel.launch

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import by.overpass.soraac.data.db.datasource.launch.LocalLaunchDataSourceImpl
import by.overpass.soraac.data.model.pojo.db.Launch
import by.overpass.soraac.data.network.datasource.launch.RemoteLaunchDataSourceImpl
import by.overpass.soraac.repository.launch.ILaunchRepository
import by.overpass.soraac.repository.launch.LaunchRepositoryImpl

class LaunchViewModel(
        internal var launchRepository: ILaunchRepository = LaunchRepositoryImpl(
                RemoteLaunchDataSourceImpl(),
                LocalLaunchDataSourceImpl()
        )
) : ViewModel() {

    var launches: LiveData<List<Launch>> = MutableLiveData()
        get() {
            return launchRepository.getLaunches()
        }

}