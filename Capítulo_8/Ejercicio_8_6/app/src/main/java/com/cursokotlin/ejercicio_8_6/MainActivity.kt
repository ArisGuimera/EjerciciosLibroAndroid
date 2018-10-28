package com.cursokotlin.ejercicio_8_6

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log

class MainActivity : AppCompatActivity(), ColorFragment.Callback {

    val firstFragment = ColorFragment()

    override fun onClickButton() {
        Log.i("MainActivity", "buttonFragment ha sido pulsado")
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        loadFragment()
    }

    private fun loadFragment() {
        supportFragmentManager
                .beginTransaction()
                .add(R.id.viewContainer, firstFragment, "ColorFragment")
                .commit()
    }

    private fun replaceFragment(){
        supportFragmentManager
                .beginTransaction()
                .replace(R.id.viewContainer, ColorFragment(), "SecondFragment")
                .addToBackStack(null)
                .commit()
    }

    private fun removeFragment(){
        supportFragmentManager
                .beginTransaction()
                .remove(firstFragment)
                .commit()
    }
}
