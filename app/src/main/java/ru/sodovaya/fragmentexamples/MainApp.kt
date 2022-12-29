package ru.sodovaya.fragmentexamples

import android.app.Application
import ru.sodovaya.fragmentexamples.core.LongLive

class MainApp : Application() {
    override fun onCreate() {
        super.onCreate()
        app = this
        longlive = LongLive.getInstance(this)
    }

    companion object {
        lateinit var app: MainApp
        lateinit var longlive: LongLive
    }

}
