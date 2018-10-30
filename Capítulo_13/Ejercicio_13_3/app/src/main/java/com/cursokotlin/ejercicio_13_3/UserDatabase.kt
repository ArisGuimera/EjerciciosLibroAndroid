package com.cursokotlin.ejercicio_13_3

import android.arch.persistence.room.Database
import android.arch.persistence.room.RoomDatabase

/**
 * Created by aristidesguimeraorozco on 31/10/2018.
 */

@Database(entities = arrayOf(UserEntity::class), version = 1)
abstract class UserDatabase: RoomDatabase() {
    abstract fun userDao():UserDao
}