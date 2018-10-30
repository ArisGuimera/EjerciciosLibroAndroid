package com.cursokotlin.ejercicio_13_3

import android.app.Activity
import android.os.Bundle
import android.text.Editable
import com.cursokotlin.ejercicio_13_3.MainActivity.Companion.INTENT_BUNDLE
import com.cursokotlin.ejercicio_13_3.MainActivity.Companion.INTENT_USER
import kotlinx.android.synthetic.main.activity_profile.*

class ProfileActivity : Activity() {

    var editMode :Boolean = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)

        buttonDeleteUser.setOnClickListener { deleteProfile() }
        buttonAddUser.setOnClickListener {
            if(editMode){
                updateProfile()
            }else{
                addProfile()
            }
        }

        if(intent.extras != null){
            val bundle = intent.extras.getBundle(INTENT_BUNDLE)
            val userEntity:UserEntity = bundle.getSerializable(INTENT_USER) as UserEntity
            editMode = true
            buttonAddUser.text = "Editar perfil"
            fillProfile(userEntity)
        }
    }

    private fun updateProfile(){
        Thread(Runnable {
            DatabaseRoomapplication.database.userDao().updateTask(getUserEntity())
            runOnUiThread {
                finish()
            }
        }).start()
    }

    private fun deleteProfile(){
        Thread(Runnable {
            DatabaseRoomapplication.database.userDao().deleteUser(getUserEntity())
            runOnUiThread { finish() }
        }).start()
    }

    private fun addProfile(){
        Thread(Runnable {
            DatabaseRoomapplication.database.userDao().insertUser(getUserEntity())
            runOnUiThread { finish() }
        }).start()
    }

    private fun fillProfile(userEntity: UserEntity){
        editDni.text = userEntity.dni.toEditable()
        editName.text = userEntity.name.toEditable()
        editWeight.text = userEntity.weight.toString().toEditable()
        editHeight.text = userEntity.height.toString().toEditable()
        editAddress.text = userEntity.address.toEditable()
    }

    private fun getUserEntity():UserEntity{
        return UserEntity(
                editDni.text.toString(),
                editName.text.toString(),
                editWeight.text.toString().toInt(),
                editHeight.text.toString().toInt(),
                editAddress.text.toString()
        )
    }

    fun String.toEditable(): Editable = Editable.Factory.getInstance().newEditable(this)
}
