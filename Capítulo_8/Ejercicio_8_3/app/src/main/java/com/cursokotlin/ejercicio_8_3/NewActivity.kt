package com.cursokotlin.ejercicio_8_3

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.cursokotlin.ejercicio_8_3.MainActivity.Companion.EXTRA_NAME

class NewActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val extra = intent.extras
        if(extra != null){
            val name: String = extra.getString(EXTRA_NAME) //Contendrá el nombre Arístides
        }
    }
}
