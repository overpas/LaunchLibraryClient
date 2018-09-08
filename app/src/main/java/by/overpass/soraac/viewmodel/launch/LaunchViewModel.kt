package by.overpass.soraac.viewmodel.launch

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProviders
import android.support.v4.app.Fragment
import android.util.Log
import by.overpass.soraac.data.db.datasource.launch.LocalLaunchDataSourceImpl
import by.overpass.soraac.data.model.pojo.db.Launch
import by.overpass.soraac.data.network.datasource.launch.RemoteLaunchDataSourceImpl
import by.overpass.soraac.repository.launch.ILaunchRepository
import by.overpass.soraac.repository.launch.LaunchRepositoryImpl
import by.overpass.soraac.viewmodel.ViewModelFactory

class LaunchViewModel(
        private var launchRepository: ILaunchRepository = LaunchRepositoryImpl(
                RemoteLaunchDataSourceImpl(),
                LocalLaunchDataSourceImpl()
        )
) : ViewModel() {

    var launches: LiveData<List<Launch>> = MutableLiveData()
        get() {
            Log.i(this.javaClass.simpleName, ": getting launches")
            return launchRepository.launches
        }

    fun getById(id: Int): LiveData<Launch> = launchRepository.getById(id)

    object Factory : ViewModelFactory() {
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