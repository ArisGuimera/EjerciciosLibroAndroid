package com.cursokotlin.ejercicio_13_1

import android.app.Application

/**
 * Created by aristidesguimeraorozco on 28/10/2018.
 */
class SharedApplication:Application() {

    companion object {
        lateinit var preferences:Preferences
    }

    override fun onCreate() {
        super.onCreate()
        preferences = Preferences(applicationContext)
    }
}