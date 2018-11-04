package com.cursokotlin.ejercicio_15_4

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.design.widget.Snackbar
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        viewBottom.setOnClickListener { showSnackbar() }
    }

    private fun showSnackbar() {
        Snackbar.make(viewRoot, "¡Soy la snackbar!", Snackbar.LENGTH_SHORT).show()
    }
}
