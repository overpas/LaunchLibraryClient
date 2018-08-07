package by.overpass.soraac

import android.app.Application

class SoraacApp : Application() {

    companion object {
        private lateinit var instance: SoraacApp
        fun getAppContext() = instance.applicationContext
    }

    override fun onCreate() {
        super.onCreate()
        instance = this
    }

}