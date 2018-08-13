package by.overpass.soraac.repository

import by.overpass.soraac.data.network.datasource.ILaunchDataSource

object LaunchRepositoryFactory {
    fun createStubNetworkRepository(dataSource: ILaunchDataSource) = LaunchRepositoryImpl(dataSource)
}