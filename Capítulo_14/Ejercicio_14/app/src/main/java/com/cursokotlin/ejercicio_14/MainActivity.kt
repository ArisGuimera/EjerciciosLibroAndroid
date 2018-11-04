package com.cursokotlin.ejercicio_14

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.google.gson.Gson
import java.net.URL
import kotlin.concurrent.thread

class MainActivity : AppCompatActivity() {

    private val TAG = "MainActivity"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        getDataFromApi()
    }

    private fun getDataFromApi(){
        val USER_NAME = "arisguimera"
        val url = "https://api.github.com/users/$USER_NAME"
        thread {
            Log.i(TAG, "Iniciando el consumo de datos")
            val response = URL(url).readText()
            val user:UserModel = Gson().fromJson(response, UserModel::class.java)
            Log.i(TAG, user.toString())
        }
    }
}
