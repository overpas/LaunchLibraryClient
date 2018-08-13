package by.overpass.soraac.data.db

import android.arch.persistence.room.Room
import android.arch.persistence.room.RoomDatabase
import android.arch.persistence.room.Database
import android.content.Context
import by.overpass.soraac.model.pojo.db.Launch


@Database(entities = arrayOf(Launch::class), version = 1)
abstract class AppDB : RoomDatabase() {

    abstract fun getLaunchDao(): LaunchDao

    companion object {
        private var INSTANCE: AppDB? = null

        fun getInstance(context: Context): AppDB? {
            if (INSTANCE == null) {
                synchronized(AppDB::class) {
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                            AppDB::class.java, "launchlibrary.db")
                            .build()
                }
            }
            return INSTANCE
        }

        fun destroyInstance() {
            INSTANCE = null
        }
    }

}