package com.cursokotlin.ejemplo_8_4

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_name.*

class NameActivity : AppCompatActivity() {

    companion object {
        val EXTRA_NAME = "EXTRA_NAME"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_name)
        buttonSend.setOnClickListener { returnName() }
    }

    private fun returnName() {
        val name = editTextName.text.toString()
        if (name.isEmpty()) {
            setResult(Activity.RESULT_CANCELED)
        } else {
            val result = Intent()
            result.putExtra(EXTRA_NAME, name)
            setResult(Activity.RESULT_OK, result)
        }
        finish()
    }
}
