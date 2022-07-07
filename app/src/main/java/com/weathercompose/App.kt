package com.weathercompose

import android.app.Application
import android.content.Context

class App: Application() {


    override fun onCreate() {
        super.onCreate()
        instance = this
    }
    //Здесь у нас экземпляр нашего класса Application через который у нас будет доступ к нашим компонентам
    companion object{
        lateinit var instance:App
            private set
    }
}
val Context.app: App
    get() = applicationContext as App