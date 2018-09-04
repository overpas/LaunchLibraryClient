package by.overpass.soraac.repository.rocket

import android.arch.lifecycle.LiveData
import by.overpass.soraac.data.db.datasource.rocket.ILocalRocketDataSource
import by.overpass.soraac.data.model.pojo.db.Rocket
import by.overpass.soraac.data.network.datasource.rocket.IRemoteRocketDataSource

class RocketRepositoryImpl(
        private val remoteDataSource: IRemoteRocketDataSource,
        private val localDataSource: ILocalRocketDataSource
) : IRocketRepository {

    override val rockets: LiveData<List<Rocket>>
        get() {
            remoteDataSource.getRockets().observeForever { list ->
                list?.let { localDataSource.addRockets(it) }
            }
            return localDataSource.getRockets()
        }

    override fun getById(id: Int): LiveData<Rocket> = localDataSource.getRocketById(id)
}