package com.cursokotlin.userinterface

import android.os.Bundle
import android.support.v4.view.GravityCompat
import android.support.v7.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.toolbar.*


class MainActivity : AppCompatActivity() {

    private lateinit var pagerAdapter: PagerAdapter
    private val TAG = "MainActivity"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initToolbar()
        pagerAdapter = PagerAdapter(supportFragmentManager)
        viewPager.adapter = pagerAdapter
        viewPager.offscreenPageLimit = 2
        tabs.setupWithViewPager(viewPager)

        navview.setNavigationItemSelectedListener { menuItem ->
            showToast(menuItem.title.toString())
            menuItem.isChecked = true
            drawerLayout.closeDrawers()
            true
        }


    }

    private fun initToolbar() {
        setSupportActionBar(toolbar)
        supportActionBar!!.setHomeAsUpIndicator(R.drawable.menu)
        supportActionBar!!.setDisplayHomeAsUpEnabled(true)
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.menu_toolbar, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.option_one -> {
                showToast("opción 1")
                return true
            }
            R.id.option_two -> {
                showToast("opción 2")
                return true
            }
            R.id.option_three -> {
                showToast("opción 3")
                return true
            }
            R.id.option_four -> {
                showToast("opción 4")
                return true
            }
            R.id.option_five -> {
                showToast("opción 5")
                return true
            }
            android.R.id.home -> {
                drawerLayout.openDrawer(GravityCompat.START)
                return true
            }
            else ->
                super.onOptionsItemSelected(item)
        }
        return true
    }

    private fun showToast(text: String) {
        Toast.makeText(this, text, Toast.LENGTH_SHORT).show()
    }


}
