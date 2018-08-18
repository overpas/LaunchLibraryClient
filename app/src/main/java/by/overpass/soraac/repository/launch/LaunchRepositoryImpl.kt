package by.overpass.soraac.repository.launch

import by.overpass.soraac.data.network.datasource.launch.ILaunchDataSource

class LaunchRepositoryImpl(private val launchDataSource: ILaunchDataSource) : ILaunchRepository {
    override fun getLaunches() = launchDataSource.getLaunches()
}