package com.cursokotlin.ejercicio_12

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import kotlin.concurrent.thread

class MainActivity : AppCompatActivity() {

    private val TAG = "MainActivity"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    private fun sleep(){
        thread(name= "myThread", priority = 1) {
            Log.i(TAG, "Iniciando el hilo")
            Thread.sleep(5000)
            runOnUiThread { Toast.makeText(this, "Han pasado 5 segundos", Toast.LENGTH_SHORT).show() }
        }
    }
}
