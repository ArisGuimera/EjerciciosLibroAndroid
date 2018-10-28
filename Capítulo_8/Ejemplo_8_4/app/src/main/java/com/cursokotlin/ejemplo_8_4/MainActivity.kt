package com.cursokotlin.ejemplo_8_4

import android.app.Activity
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.cursokotlin.ejemplo_8_4.NameActivity.Companion.EXTRA_NAME
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    val NAME_REQUEST = 1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        buttonGoToName.setOnClickListener { openNameActivity() }
    }

    private fun openNameActivity() {
        val intent = Intent(this, NameActivity::class.java)
        startActivityForResult(intent, NAME_REQUEST)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        when (requestCode){
            NAME_REQUEST -> {
                if (resultCode == Activity.RESULT_OK){
                    val name = data?.getStringExtra(EXTRA_NAME)
                    Toast.makeText(this, name, Toast.LENGTH_SHORT).show()
                }else{
                    Toast.makeText(this, "Nombre vacío", Toast.LENGTH_SHORT).show()
                }
            }
        }
    }
}
