package com.cursokotlin.ejercicio_13_3

import android.arch.persistence.room.*

/**
 * Created by aristidesguimeraorozco on 31/10/2018.
 */
@Dao
interface UserDao {

    @Query("SELECT * FROM user_entity WHERE dni like :arg0")
    fun getUserByDNI(dni : String): UserEntity

    @Insert
    fun insertUser(userEntity: UserEntity):Long

    @Delete
    fun deleteUser(userEntity: UserEntity):Int

    @Update
    fun updateTask(userEntity: UserEntity):Int
}