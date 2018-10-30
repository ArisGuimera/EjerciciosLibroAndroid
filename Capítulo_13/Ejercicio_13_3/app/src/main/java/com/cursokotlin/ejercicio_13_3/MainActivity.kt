package com.cursokotlin.ejercicio_13_3

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    companion object {
        val INTENT_USER: String = "INTENT_USER"
        val INTENT_BUNDLE: String = "INTENT_BUNDLE"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        buttonGoToProfile.setOnClickListener { goToProfile() }
        buttonSearchByDni.setOnClickListener { searchByDni(editSearcher.text.toString()) }
    }

    private fun searchByDni(dni: String) {
        if (dni.isEmpty()) {
            showToast("El DNI no puede estar vacío")
        } else {
            Thread(Runnable {
                val userEntity = DatabaseRoomapplication.database.userDao().getUserByDNI(dni)
                runOnUiThread {
                    if (userEntity != null) {
                        goToProfileWithUser(userEntity)
                    } else {
                        showToast("No hay perfil con ese DNI")
                    }
                }
            }).start()
        }
    }

    private fun goToProfileWithUser(userEntity: UserEntity) {
        val intent = Intent(this, ProfileActivity::class.java)
        val bundle = Bundle()
        bundle.putSerializable(INTENT_USER, userEntity)
        intent.putExtra(INTENT_BUNDLE, bundle)
        startActivity(intent)
    }

    private fun goToProfile() {
        val intent = Intent(this, ProfileActivity::class.java)
        startActivity(intent)
    }

    private fun showToast(text: String) {
        Toast.makeText(this, text, Toast.LENGTH_SHORT).show()
    }
}
