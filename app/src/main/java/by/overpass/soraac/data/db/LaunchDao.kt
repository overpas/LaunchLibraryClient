package by.overpass.soraac.data.db

import android.arch.persistence.room.Dao
import android.arch.lifecycle.LiveData
import android.arch.persistence.room.Insert
import android.arch.persistence.room.Query
import by.overpass.soraac.data.model.pojo.db.Launch
import android.arch.persistence.room.OnConflictStrategy.REPLACE


@Dao
interface LaunchDao {

    @Insert(onConflict = REPLACE)
    fun insert(launch: Launch)

    @Query("SELECT * FROM Launch")
    fun getAll(): LiveData<Launch>

}