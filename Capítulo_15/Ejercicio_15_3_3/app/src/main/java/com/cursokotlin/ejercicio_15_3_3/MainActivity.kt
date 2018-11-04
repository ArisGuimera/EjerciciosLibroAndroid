package com.cursokotlin.ejercicio_15_3_3

import android.animation.ObjectAnimator
import android.animation.ValueAnimator
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initObjectAnimation()
    }

    private fun initAnimation(){
        val va = ValueAnimator.ofFloat(0f, 300f)
        va.duration = 1000
        va.repeatCount = 5
        va.addUpdateListener { animation ->
            imageAnimation.translationX = animation.animatedValue as Float
            imageAnimation.translationY = animation.animatedValue as Float
        }
        va.start()
    }

    private fun initObjectAnimation(){
        val horizontalAnimation = ObjectAnimator.ofFloat(imageAnimation, "translationX", 100f)
        horizontalAnimation.duration = 1000
        horizontalAnimation.start()

        val verticalAnimation = ObjectAnimator.ofFloat(imageAnimation, "translationY", 100f)
        verticalAnimation.duration = 1000
        verticalAnimation.start()
    }
}
