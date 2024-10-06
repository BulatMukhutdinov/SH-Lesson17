package tat.mukhutdinov.lesson19

import android.app.Application
import tat.mukhutdinov.lesson19.data.AppContainer
import tat.mukhutdinov.lesson19.data.DefaultAppContainer

class BluromaticApplication : Application() {
    /** AppContainer instance used by the rest of classes to obtain dependencies */
    lateinit var container: AppContainer
    override fun onCreate() {
        super.onCreate()
        container = DefaultAppContainer(this)
    }
}
