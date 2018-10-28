package com.cursokotlin.ejercicio_8_3

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    companion object {
        val EXTRA_NAME = "EXTRA_NAME"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        button.setOnClickListener { openActivity() }
    }

    fun openActivity(){
        val intent = Intent(this, NewActivity::class.java)
        intent.putExtra(EXTRA_NAME, "Arístides")
        startActivity(intent)
    }
}
