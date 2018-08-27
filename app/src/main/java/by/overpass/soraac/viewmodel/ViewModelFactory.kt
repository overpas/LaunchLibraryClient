package by.overpass.soraac.viewmodel

import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProviders
import android.support.v4.app.Fragment
import by.overpass.soraac.data.db.datasource.launch.LocalLaunchDataSourceImpl
import by.overpass.soraac.data.network.datasource.launch.RemoteLaunchDataSourceImpl
import by.overpass.soraac.repository.launch.LaunchRepositoryImpl
import by.overpass.soraac.viewmodel.launch.LaunchViewModel

sealed class ViewModelFactory {

    abstract fun get(fragment: Fragment): ViewModel

    object Launch : ViewModelFactory() {
        override fun get(fragment: Fragment) = ViewModelProviders
                .of(fragment)
                .get(LaunchViewModel::class.java)
                .also {
                    it.launchRepository = LaunchRepositoryImpl(
                            RemoteLaunchDataSourceImpl(),
                            LocalLaunchDataSourceImpl()
                    )
                }

    }

}