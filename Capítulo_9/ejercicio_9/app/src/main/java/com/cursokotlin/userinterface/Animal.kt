package com.cursokotlin.userinterface

import android.os.Parcel
import android.os.Parcelable
import java.io.Serializable

/**
 * Created by Aris on 05/02/2018.
 */
data class Animal(
        var name:String,
        var description:String,
        var image:Int) : Serializable


