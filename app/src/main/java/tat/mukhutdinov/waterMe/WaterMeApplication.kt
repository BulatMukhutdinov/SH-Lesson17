package tat.mukhutdinov.waterMe

import android.app.Application
import tat.mukhutdinov.waterMe.data.AppContainer
import tat.mukhutdinov.waterMe.data.DefaultAppContainer

class WaterMeApplication : Application() {
    /** AppContainer instance used by the rest of classes to obtain dependencies */
    lateinit var container: AppContainer
    override fun onCreate() {
        super.onCreate()
        container = DefaultAppContainer(this)
    }
}
