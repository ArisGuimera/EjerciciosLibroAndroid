package com.cursokotlin.ejercicio_11

import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v4.app.NotificationCompat
import android.support.v4.content.ContextCompat
import android.support.v7.app.AlertDialog
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    val NOTIFICATION_ID = 234
    val CHANNEL_ID = "my_channel_01"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        buttonToast.setOnClickListener { showToast() }
        buttonSnackbar.setOnClickListener { showSnackbar("Ha hecho clic.") }
        buttonSnackbarCustom.setOnClickListener { showSnackbarCustom("Ha hecho clic.") }
        buttonSnackbarCustomWithColor.setOnClickListener { showSnackbarCustomWithColor("Ha hecho clic.") }
        buttonDialog.setOnClickListener { showDialog() }
        buttonDialogWithButtons.setOnClickListener { showDialogWithButtons() }
        buttonDialogArray.setOnClickListener { showDialogArray() }
        buttonCustomDialog.setOnClickListener { showCustomDialog() }
        buttonNotification.setOnClickListener { sendNotification() }
    }

    private fun showToast(){
        Toast.makeText(this, "Clic!", Toast.LENGTH_SHORT).show()
    }

    private fun showSnackbar(text:String){
        Snackbar.make(view,text, Snackbar.LENGTH_SHORT).show()
    }

    private fun showSnackbarCustom(text:String){
        Snackbar.make(view, text, Snackbar.LENGTH_SHORT).setAction("Acción", {someAction()}).show()
    }

    private fun someAction() {
        //Este es una función de ejemplo a la cual llamaríamos desde cualquier acción.
    }

    private fun showSnackbarCustomWithColor(text:String){
        Snackbar.make(view, text, Snackbar.LENGTH_SHORT)
                .setAction("Acción", {someAction()})
                .setActionTextColor(ContextCompat.getColor(this, R.color.colorPrimary))
                .show()
    }

    //Diálogo

    fun getDialog():AlertDialog{
        val builder = AlertDialog.Builder(this)
        builder.setMessage("Mensaje de ejemplo").setTitle("Título")
        val dialog:AlertDialog = builder.create()
        return dialog
    }

    //Diálogo simplificado

    private fun showDialog(){
        AlertDialog.Builder(this)
                .setMessage("Mensaje de ejemplo")
                .setTitle("Título")
                .create()
                .show()
    }

    private fun showDialogWithButtons(){
        AlertDialog.Builder(this)
                .setMessage("Mensaje de ejemplo")
                .setTitle("Título")
                .setPositiveButton("Positivo", {_,_ -> someAction()})
                .setNegativeButton("Negativo", {_,_ -> someAction()})
                .setNeutralButton("Neutral", {_,_ -> someAction()})
                .create()
                .show()
    }

    //Diálogo con array

    private fun showDialogArray(){
        AlertDialog.Builder(this)
                .setTitle("Título")
                .setNegativeButton("Negativo", {_,_ -> someAction()})
                .setItems(resources.getStringArray(R.array.options), {_, which -> getItemByPosition(which)})
                .setCancelable(false)
                .create()
                .show()
    }

    private fun getItemByPosition(position: Int) {
        val selected:String = resources.getStringArray(R.array.options)[position]
        Toast.makeText(this, selected, Toast.LENGTH_SHORT).show()
    }

    //Dialogo personalizado

    private fun showCustomDialog(){
        AlertDialog.Builder(this)
                .setView(layoutInflater.inflate(R.layout.dialog_loading, null))
                .setCancelable(false)
                .create()
                .show()
    }

    //Notificaciones

    private fun getNotificationBuilder():NotificationCompat.Builder{
        return NotificationCompat.Builder(this, "")
                .setSmallIcon(android.R.drawable.star_on)
                .setContentTitle("Título de la alerta")
                .setContentText("Este es el contenido.")
    }

    private fun sendNotification(){
        val notificationManager = getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
        val intent = Intent(this, MainActivity::class.java)
        val pendingIntent = PendingIntent.getActivity(this, 0, intent, 0)
        val notification = getNotificationBuilder().setContentIntent(pendingIntent)

        if(android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O){
            val name = "my_channel"
            val description = "this is my channel"
            val importance = NotificationManager.IMPORTANCE_HIGH
            val mChannel = NotificationChannel(CHANNEL_ID, name, importance)
            mChannel.description = description
            mChannel.enableVibration(true)
            mChannel.vibrationPattern = longArrayOf(100, 200, 300, 400, 500, 400, 300, 200, 400)
            mChannel.setShowBadge(false)
            notificationManager.createNotificationChannel(mChannel)
        }
        notificationManager.notify(220, notification.build())
    }

}
