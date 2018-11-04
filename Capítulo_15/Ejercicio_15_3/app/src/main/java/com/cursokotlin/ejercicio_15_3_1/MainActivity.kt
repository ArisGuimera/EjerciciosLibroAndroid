package com.cursokotlin.ejercicio_15_3_1

import android.graphics.drawable.AnimationDrawable
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    lateinit var animDrawable: AnimationDrawable

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        animDrawable = imageAnimation.background as AnimationDrawable
        imageAnimation.setOnClickListener { initAnimation() }
    }

    private fun initAnimation() {
        animDrawable.stop()
        animDrawable.start()
    }
}
