package by.overpass.soraac.data.db.datasource.launch

import android.arch.lifecycle.LiveData
import by.overpass.soraac.data.model.pojo.db.Launch

class LocalLaunchDataSourceImpl : ILocalLaunchDataSource {

    override fun getLaunches(): LiveData<List<Launch>> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun addLaunches(vararg launch: Launch) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

}