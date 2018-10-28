package com.cursokotlin.capitulo_82

import android.support.v7.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {

    val STATE_NAME = "STATE NAME"
    val username = "Arístides" //En este ejemplo es una variable, pero podría ser un valor que recogemos del usuario.

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var recoveredValue = savedInstanceState?.get(STATE_NAME) //Contendrá el valor de username.
    }

    override fun onSaveInstanceState(savedInstanceState: Bundle?) {
        savedInstanceState?.putString(STATE_NAME, username)
        super.onSaveInstanceState(savedInstanceState)
    }
}
