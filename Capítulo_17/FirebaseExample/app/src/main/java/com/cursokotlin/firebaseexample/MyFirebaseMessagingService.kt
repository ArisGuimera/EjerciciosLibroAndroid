package com.cursokotlin.firebaseexample

import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.media.RingtoneManager
import android.support.v4.app.NotificationCompat
import android.util.Log
import com.google.firebase.iid.FirebaseInstanceIdService
import com.google.firebase.messaging.FirebaseMessagingService
import com.google.firebase.messaging.RemoteMessage
import android.app.NotificationChannel
import android.app.TaskStackBuilder
import android.graphics.Color


/**
 * Created by Aris on 25/02/2018.
 */
class MyFirebaseMessagingService : FirebaseMessagingService() {

    val TAG = "FirebaseMessaging"

    override fun onMessageReceived(remoteMessage: RemoteMessage?) {
        Log.d(TAG, "onMessageReceived")
        val body = remoteMessage!!.notification!!.body!!
        sendNotification(body)
    }

    private fun sendNotification(body: String) {
        val NOTIFICATION_ID = 234
        val CHANNEL_ID = "my_channel_01"

        val notificationManager = getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager

        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
            val name = "my_channel"
            val description = "This is my channel"
            val importance = NotificationManager.IMPORTANCE_HIGH
            val mChannel = NotificationChannel(CHANNEL_ID, name, importance)
            mChannel.description = description
            mChannel.enableVibration(true)
            mChannel.vibrationPattern = longArrayOf(100, 200, 300, 400, 500, 400, 300, 200, 400)
            mChannel.setShowBadge(false)
            notificationManager.createNotificationChannel(mChannel)
        }

        val builder = NotificationCompat.Builder(this, CHANNEL_ID)
                .setSmallIcon(R.mipmap.ic_launcher)
                .setContentTitle("Notification")
                .setContentText(body)

        val resultIntent = Intent(this, MainActivity::class.java)
        val stackBuilder = TaskStackBuilder.create(this)
        stackBuilder.addParentStack(MainActivity::class.java)
        stackBuilder.addNextIntent(resultIntent)
        val resultPendingIntent = stackBuilder.getPendingIntent(0, PendingIntent.FLAG_UPDATE_CURRENT)

        builder.setContentIntent(resultPendingIntent)

        notificationManager.notify(NOTIFICATION_ID, builder.build())
    }
}