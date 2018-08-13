package by.overpass.soraac.repository

import by.overpass.soraac.data.network.datasource.ILaunchDataSource

class LaunchRepositoryImpl(private val launchDataSource: ILaunchDataSource) : ILaunchRepository {
    override fun getLaunches() = launchDataSource.getLaunches()
}