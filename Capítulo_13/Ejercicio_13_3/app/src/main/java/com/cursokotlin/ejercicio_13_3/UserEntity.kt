package com.cursokotlin.ejercicio_13_3

import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey
import java.io.Serializable

/**
 * Created by aristidesguimeraorozco on 31/10/2018.
 */
@Entity(tableName = "user_entity")
data class UserEntity (
        @PrimaryKey()
        var dni:String = "",
        var name:String = "",
        var weight:Int = 0,
        var height:Int = 0,
        var address:String = ""
): Serializable
