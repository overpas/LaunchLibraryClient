package by.overpass.soraac.viewmodel

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import by.overpass.soraac.data.network.datasource.LaunchDataSourceFactory
import by.overpass.soraac.model.pojo.db.Launch
import by.overpass.soraac.repository.ILaunchRepository
import by.overpass.soraac.repository.LaunchRepositoryFactory

class LaunchViewModel(
        internal var launchRepository: ILaunchRepository =
                LaunchRepositoryFactory.createStubNetworkRepository(
                        LaunchDataSourceFactory.createStubNetworkDataSource()
                )
) : ViewModel() {

    var launches: LiveData<List<Launch>> = MutableLiveData()
        get() {
            return launchRepository.getLaunches()
        }

}