package com.cursokotlin.firebaseexample

import android.util.Log
import com.google.firebase.iid.FirebaseInstanceId
import com.google.firebase.iid.FirebaseInstanceIdService

/**
 * Created by Aris on 25/02/2018.
 */
class MyFirebaseInstanceIdService:FirebaseInstanceIdService(){

    val TAG = "FirebaseMessaging"

    override fun onTokenRefresh(){
        super.onTokenRefresh()
        Log.i("onTokenRefresh", "tokenRefreshed")
        val refreshedToken = FirebaseInstanceId.getInstance().token
        sendRegistrationToServer(refreshedToken)
    }

    private fun sendRegistrationToServer(refreshedToken: String?) {
        Log.d("onTokenRefresh", refreshedToken)
    }

}