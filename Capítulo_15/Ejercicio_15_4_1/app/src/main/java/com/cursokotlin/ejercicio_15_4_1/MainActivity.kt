package com.cursokotlin.ejercicio_15_4_1

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.app.ActivityOptionsCompat
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.animation.AnimationUtils
import android.widget.ImageView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private var clicked:Boolean = true

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)
        supportActionBar?.title = "Mi título"
        setupRecyclerView()
        buttonFab.setOnClickListener { rotateFAB() }
    }

    private fun setupRecyclerView() {
        rvSimpleList.setHasFixedSize(true)
        rvSimpleList.layoutManager = LinearLayoutManager(this)
        val recyclerAdapter: RecyclerAdapter = RecyclerAdapter(getSimpleList(), {openDetail(it)})
        rvSimpleList.adapter = recyclerAdapter
        rvSimpleList.addOnScrollListener(object : RecyclerView.OnScrollListener() {
            override fun onScrolled(recyclerView: RecyclerView?, dx: Int, dy: Int) {
                if(dy<0){
                    buttonFab.show()
                }else if (dy > 0) {
                    buttonFab.hide()
                }
            }
        })
    }

    fun openDetail(image:ImageView){
        val intent = Intent(this, DetailActivity::class.java)
        val options = ActivityOptionsCompat.makeSceneTransitionAnimation(this, image, "imageDefault")
        startActivity(intent, options.toBundle())
    }

    private fun getSimpleList(): ArrayList<String> {
        val simpleList: ArrayList<String> = ArrayList()
        for (i in 0..20) {
            simpleList.add("Esta es la descripción de la posición $i")
        }
        return simpleList
    }

    private fun rotateFAB(){
        val interpolator = AnimationUtils.loadInterpolator(this, android.R.interpolator.fast_out_slow_in)
        buttonFab.animate()
                .rotation(if (clicked) 45f else 0f)
                .setInterpolator(interpolator)
                .start()
        clicked = !clicked
    }
}
