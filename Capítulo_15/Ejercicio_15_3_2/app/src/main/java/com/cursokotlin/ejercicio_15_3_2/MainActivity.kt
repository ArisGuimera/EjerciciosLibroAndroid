package com.cursokotlin.ejercicio_15_3_2

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.animation.*
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    lateinit var animPosicionView: TranslateAnimation
    lateinit var animSizeView: ScaleAnimation
    lateinit var animRotateView: RotateAnimation
    lateinit var animAlphaView: AlphaAnimation
    lateinit var animView: Animation

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initAnimation() //Sustituir el método por el tipo de animación que nos interese.
        imageAnimation.setOnClickListener { anitAnimation() }
    }

    private fun anitAnimation() {
        imageAnimation.startAnimation(animView) //Añadir aquí el anim que estemos usando.
    }

    /**
     * Tipos de animación
     */

    private fun initPosicionAnimation() {
        animPosicionView = TranslateAnimation(0f, 100f, 0f, 300f)
        animPosicionView.duration = 2000
        animPosicionView.fillAfter = true
    }

    private fun initSizeAnimation() {
        animSizeView = ScaleAnimation(1f, 1.5f, 1f, 1.5f)
        animSizeView.duration = 1000
        animSizeView.fillAfter = true
    }

    private fun initRotateAnimation() {
        animRotateView = RotateAnimation(0f, 180f,
                RotateAnimation.RELATIVE_TO_SELF, 0.5f,
                RotateAnimation.RELATIVE_TO_SELF, 0.5f)
        animRotateView.duration = 1000
        animRotateView.fillAfter = true
    }

    private fun initAlphaAnimation(){
        animAlphaView = AlphaAnimation(1f, 0f)
        animAlphaView.duration = 1000
        animAlphaView.fillAfter = true
    }

    private fun initAnimation(){
        animView = AnimationUtils.loadAnimation(this, R.anim.view_animation)
    }
}
