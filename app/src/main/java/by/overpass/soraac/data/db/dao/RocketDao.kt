package by.overpass.soraac.data.db.dao

import android.arch.lifecycle.LiveData
import android.arch.persistence.room.Dao
import android.arch.persistence.room.Insert
import android.arch.persistence.room.OnConflictStrategy
import android.arch.persistence.room.Query
import by.overpass.soraac.data.model.pojo.db.Rocket

@Dao
interface RocketDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(Rocket: Rocket)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(rockets: List<Rocket>)

    @Query("SELECT * FROM Rocket ORDER BY name")
    fun selectAllOrderedByName(): LiveData<List<Rocket>>

    @Query("SELECT * FROM Rocket WHERE id = :id")
    fun selectById(id: Int): LiveData<Rocket>
}
