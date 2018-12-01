package com.cursokotlin.animallist

import java.io.Serializable

/**
 * Created by aristidesguimeraorozco on 10/3/18.
 */
data class Animal(
        val name:String,
        val description:String,
        val image:String):Serializable