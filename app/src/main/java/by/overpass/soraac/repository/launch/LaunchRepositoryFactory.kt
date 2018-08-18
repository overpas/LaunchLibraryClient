package by.overpass.soraac.repository.launch

import by.overpass.soraac.data.network.datasource.launch.ILaunchDataSource

object LaunchRepositoryFactory {
    fun createStubNetworkRepository(dataSource: ILaunchDataSource) = LaunchRepositoryImpl(dataSource)
}