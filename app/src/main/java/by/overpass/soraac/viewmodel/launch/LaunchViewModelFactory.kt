package by.overpass.soraac.viewmodel.launch

import android.arch.lifecycle.ViewModelProviders
import android.support.v4.app.Fragment
import by.overpass.soraac.data.db.datasource.launch.LocalLaunchDataSourceImpl
import by.overpass.soraac.data.network.datasource.launch.RemoteLaunchDataSourceImpl
import by.overpass.soraac.repository.launch.LaunchRepositoryImpl

object LaunchViewModelFactory {

    fun createStub(fragment: Fragment): LaunchViewModel {
        val viewModel = ViewModelProviders.of(fragment).get(LaunchViewModel::class.java)
        viewModel.launchRepository = LaunchRepositoryImpl(
                RemoteLaunchDataSourceImpl(),
                LocalLaunchDataSourceImpl()
        )
        return viewModel
    }

}