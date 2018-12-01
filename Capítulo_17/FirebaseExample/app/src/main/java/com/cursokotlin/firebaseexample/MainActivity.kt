package com.cursokotlin.firebaseexample

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.app.AlertDialog
import android.util.Log
import com.google.android.gms.ads.*
import com.google.firebase.iid.FirebaseInstanceId
import kotlinx.android.synthetic.main.activity_main.*
import com.google.firebase.analytics.FirebaseAnalytics
import android.R.attr.name
import com.crashlytics.android.Crashlytics
import java.util.*


class MainActivity : AppCompatActivity() {

    val APP_ID = "ca-app-pub-3940256099942544~3347511713"
    lateinit var firebaseAnalytics: FirebaseAnalytics

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initAdmob()
        initAnalytics()
        trackOpenedApp()
        buttonTracking.setOnClickListener { launchEvent() }
        buttonCrash.setOnClickListener { forceCrash() }
    }

    private fun launchEvent() {
        val bundle = Bundle()
        bundle.putString(FirebaseAnalytics.Param.ITEM_ID, "001")
        bundle.putString(FirebaseAnalytics.Param.ITEM_NAME, "app opened")
        bundle.putString(FirebaseAnalytics.Param.CONTENT_TYPE, "screen")
        firebaseAnalytics.logEvent(FirebaseAnalytics.Event.SELECT_CONTENT, bundle)
    }

    private fun forceCrash() {
        Crashlytics.getInstance().crash()
    }


    private fun initAnalytics() {
        firebaseAnalytics = FirebaseAnalytics.getInstance(this)
        firebaseAnalytics.setUserProperty("language", Locale.getDefault().displayLanguage)
    }

    private fun initAdmob() {
        MobileAds.initialize(this, APP_ID)
        val adRequest = AdRequest.Builder().build()
        adView.loadAd(adRequest)
    }

    private fun trackOpenedApp() {
        val bundle = Bundle()
        bundle.putString(FirebaseAnalytics.Param.ITEM_ID, "001")
        bundle.putString(FirebaseAnalytics.Param.ITEM_NAME, "app opened")
        bundle.putString(FirebaseAnalytics.Param.CONTENT_TYPE, "screen")
        firebaseAnalytics.logEvent(FirebaseAnalytics.Event.SELECT_CONTENT, bundle)
    }
}
