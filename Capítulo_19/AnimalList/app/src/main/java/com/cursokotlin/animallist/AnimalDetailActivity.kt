package com.cursokotlin.animallist

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import com.cursokotlin.animallist.MainActivity.Companion.EXTRA_ANIMAL
import kotlinx.android.synthetic.main.activity_animal_detail.*

class AnimalDetailActivity : AppCompatActivity() {

    private lateinit var animal:Animal

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_animal_detail)
        if (intent != null) {
            animal = intent.extras.getSerializable(EXTRA_ANIMAL) as Animal
        }
        initToolbar()
        initView()
    }

    private fun initView() {
        textDescription.text = animal.description
        imageDetail.loadUrl(animal.image)
    }

    private fun initToolbar() {
        setSupportActionBar(toolbar)
        supportActionBar?.title = animal.name
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            android.R.id.home -> {
                onBackPressed()
                return true
            }
        }
        return super.onOptionsItemSelected(item)
    }
}
