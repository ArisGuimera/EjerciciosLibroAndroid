package com.cursokotlin.animallist

import android.widget.ImageView
import com.squareup.picasso.Picasso

/**
 * Created by aristidesguimeraorozco on 10/3/18.
 */

fun ImageView.loadUrl(url:String){
    Picasso.get().load(url).into(this)
}