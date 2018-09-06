package by.overpass.soraac.data.db.dao

import android.arch.lifecycle.LiveData
import android.arch.persistence.room.Dao
import android.arch.persistence.room.Insert
import android.arch.persistence.room.OnConflictStrategy
import android.arch.persistence.room.Query
import by.overpass.soraac.data.model.pojo.db.Mission

@Dao
interface MissionDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(mission: Mission)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(missions: List<Mission>)

    @Query("SELECT * FROM Mission ORDER BY name")
    fun selectAllOrderedByName(): LiveData<List<Mission>>

    @Query("SELECT * FROM Mission WHERE id = :id")
    fun selectById(id: Int): LiveData<Mission>

}