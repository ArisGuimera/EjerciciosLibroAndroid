package com.cursokotlin.ejercicio_13_1

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.text.Editable
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        getValuesFromShared()
        buttonLogin.setOnClickListener { onClickLogin() }
    }

    private fun getValuesFromShared() {
        editTextUser.text = SharedApplication.preferences.user.toEditable()
        editTextPass.text = SharedApplication.preferences.pass.toEditable()
    }

    private fun onClickLogin() {
        if (checkRememberUser.isChecked) {
            persistValues()
        } else {
            deleteValues()
        }
    }

    private fun persistValues() {
        if (editTextUser.text.isEmpty() || editTextPass.text.isEmpty()) {
            showToast("Los datos no pueden estar vacíos")
        } else {
            SharedApplication.preferences.user = editTextUser.text.toString()
            SharedApplication.preferences.pass = editTextPass.text.toString()
            showToast("Datos guardados")
        }
    }

    private fun deleteValues() {
        SharedApplication.preferences.clear()
        showToast("Datos borrados")
    }

    private fun showToast(text: String) {
        Toast.makeText(this, text, Toast.LENGTH_SHORT).show()
    }

    private fun String.toEditable(): Editable = Editable.Factory.getInstance().newEditable(this)
}
