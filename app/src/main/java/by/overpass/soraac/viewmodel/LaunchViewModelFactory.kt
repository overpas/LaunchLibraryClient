package by.overpass.soraac.viewmodel

import android.arch.lifecycle.ViewModelProviders
import android.support.v4.app.Fragment
import by.overpass.soraac.data.network.datasource.LaunchDataSourceFactory
import by.overpass.soraac.repository.LaunchRepositoryFactory

object LaunchViewModelFactory {

    fun createStub(fragment: Fragment): LaunchViewModel {
        val viewModel = ViewModelProviders.of(fragment).get(LaunchViewModel::class.java)
        viewModel.launchRepository = LaunchRepositoryFactory.createStubNetworkRepository(
                LaunchDataSourceFactory.createStubNetworkDataSource()
        )
        return viewModel
    }

}