package tat.mukhutdinov.bluromatic

import android.app.Application
import tat.mukhutdinov.bluromatic.data.AppContainer
import tat.mukhutdinov.bluromatic.data.DefaultAppContainer

class BluromaticApplication : Application() {
    /** AppContainer instance used by the rest of classes to obtain dependencies */
    lateinit var container: AppContainer
    override fun onCreate() {
        super.onCreate()
        container = DefaultAppContainer(this)
    }
}
