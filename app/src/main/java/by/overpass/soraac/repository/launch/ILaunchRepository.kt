package by.overpass.soraac.repository.launch

import android.arch.lifecycle.LiveData
import by.overpass.soraac.data.model.pojo.db.Launch

interface ILaunchRepository {
    fun getById(id: Int): LiveData<Launch>

    val launches: LiveData<List<Launch>>
}