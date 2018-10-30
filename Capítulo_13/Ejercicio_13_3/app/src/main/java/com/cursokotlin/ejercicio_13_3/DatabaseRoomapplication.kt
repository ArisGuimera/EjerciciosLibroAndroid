package com.cursokotlin.ejercicio_13_3

import android.app.Application
import android.arch.persistence.room.Room

/**
 * Created by aristidesguimeraorozco on 31/10/2018.
 */
class DatabaseRoomapplication: Application() {
    companion object {
        lateinit var database: UserDatabase
    }

    override fun onCreate() {
        super.onCreate()
        DatabaseRoomapplication.database = Room.databaseBuilder(this, UserDatabase::class.java, "user-db").build()
    }
}