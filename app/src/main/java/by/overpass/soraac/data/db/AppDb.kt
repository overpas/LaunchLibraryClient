package by.overpass.soraac.data.db

import android.arch.persistence.room.Room
import android.arch.persistence.room.RoomDatabase
import android.arch.persistence.room.Database
import android.content.Context
import by.overpass.soraac.data.model.pojo.db.Launch


@Database(entities = [Launch::class], version = 1)
abstract class AppDB : RoomDatabase() {

    abstract fun getLaunchDao(): LaunchDao

    companion object {
        private var INSTANCE: AppDB? = null

        fun getInstance(context: Context) =
                INSTANCE ?: synchronized(AppDB::class) {
                    INSTANCE ?: Room.databaseBuilder(
                            context.applicationContext,
                            AppDB::class.java,
                            "launchlibrary.db")
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