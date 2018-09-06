package by.overpass.soraac.data.db

import android.arch.persistence.room.Room
import android.arch.persistence.room.RoomDatabase
import android.arch.persistence.room.Database
import android.content.Context
import by.overpass.soraac.data.db.dao.LaunchDao
import by.overpass.soraac.data.db.dao.MissionDao
import by.overpass.soraac.data.db.dao.RocketDao
import by.overpass.soraac.data.model.pojo.db.Launch
import by.overpass.soraac.data.model.pojo.db.Mission
import by.overpass.soraac.data.model.pojo.db.Rocket


@Database(entities = [Launch::class, Rocket::class, Mission::class], version = 4)
abstract class AppDB : RoomDatabase() {

    abstract fun getLaunchDao(): LaunchDao

    abstract fun getRocketDao(): RocketDao

    abstract fun getMissionDao(): MissionDao

    companion object {
        private var INSTANCE: AppDB? = null

        fun getInstance(context: Context) =
                INSTANCE ?: synchronized(AppDB::class) {
                    INSTANCE ?: Room.databaseBuilder(
                            context.applicationContext,
                            AppDB::class.java,
                            "launchlibrary.db")
                            .fallbackToDestructiveMigration()
                            .build()
                            .also {
                                INSTANCE = it
                            }
                }
    }

    fun destroyInstance() {
        INSTANCE = null
    }
}