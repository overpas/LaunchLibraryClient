package by.overpass.soraac.viewmodel.rocket

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProviders
import android.support.v4.app.Fragment
import by.overpass.soraac.data.db.datasource.rocket.LocalRocketDataSourceImpl
import by.overpass.soraac.data.model.pojo.db.Rocket
import by.overpass.soraac.data.network.datasource.rocket.RemoteRocketDataSourceImpl
import by.overpass.soraac.repository.rocket.IRocketRepository
import by.overpass.soraac.repository.rocket.RocketRepositoryImpl
import by.overpass.soraac.viewmodel.ViewModelFactory

class RocketViewModel(
        private var rocketRepository: IRocketRepository = RocketRepositoryImpl(
                RemoteRocketDataSourceImpl(),
                LocalRocketDataSourceImpl()
        )
) : ViewModel() {

    val rockets: LiveData<List<Rocket>>
        get() = rocketRepository.rockets

    fun getById(id: Int) = rocketRepository.getById(id)

    object Factory : ViewModelFactory() {
        override fun get(fragment: Fragment) = ViewModelProviders
                .of(fragment)
                .get(RocketViewModel::class.java)
                .also {
                    it.rocketRepository = RocketRepositoryImpl(
                            RemoteRocketDataSourceImpl(),
                            LocalRocketDataSourceImpl()
                    )
                }
    }

}