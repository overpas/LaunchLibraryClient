package by.overpass.soraac.viewmodel

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProviders
import android.support.v4.app.Fragment
import by.overpass.soraac.data.network.datasource.LaunchDataSourceFactory
import by.overpass.soraac.model.pojo.db.Launch
import by.overpass.soraac.repository.ILaunchRepository
import by.overpass.soraac.repository.LaunchRepositoryFactory

class LaunchViewModel(
        private var launchRepository: ILaunchRepository =
                LaunchRepositoryFactory.createStubNetworkRepository(
                        LaunchDataSourceFactory.createStubNetworkDataSource()
                )
) : ViewModel() {

    var launches: LiveData<List<Launch>> = MutableLiveData()
        get() {
            return launchRepository.getLaunches()
        }

    companion object Factory {
        fun createStub(fragment: Fragment): LaunchViewModel {
            val viewModel = ViewModelProviders.of(fragment).get(LaunchViewModel::class.java)
            viewModel.launchRepository = LaunchRepositoryFactory.createStubNetworkRepository(
                    LaunchDataSourceFactory.createStubNetworkDataSource()
            )
            return viewModel
        }
    }

}