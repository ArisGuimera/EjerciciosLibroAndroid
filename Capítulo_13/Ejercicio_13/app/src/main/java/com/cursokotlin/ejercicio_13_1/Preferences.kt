package com.cursokotlin.ejercicio_13_1

import android.content.Context
import android.content.SharedPreferences

/**
 * Created by aristidesguimeraorozco on 28/10/2018.
 */
class Preferences(context: Context) {

    val PREFS_NAME = "com.cursokotlin.sharedpreferences"
    val SHARED_USER = "shared_user"
    val SHARED_PASS = "shared_pass"
    val prefs: SharedPreferences = context.getSharedPreferences(PREFS_NAME, 0)

    var user: String
        get() = prefs.getString(SHARED_USER, "")
        set(value) = prefs.edit().putString(SHARED_USER, value).apply()

     var pass: String
        get() = prefs.getString(SHARED_PASS, "")
        set(value) = prefs.edit().putString(SHARED_PASS, value).apply()

    fun clear(){
        user = ""
        pass = ""
    }
}