package com.cursokotlin.userinterface

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter

/**
 * Created by Aris on 04/02/2018.
 */
class PagerAdapter(fm: FragmentManager) : FragmentPagerAdapter(fm) {

    override fun getItem(position: Int): Fragment {
        when (position) {
            0 -> return ExampleFragment.newInstance("ejemplo1", getAquaticAnimals())
            1 -> return ExampleFragment.newInstance("ejemplo2", getLandAnimals())
            2 -> return ExampleFragment.newInstance("ejemplo3", getFlyingAnimals())
        }
        return ExampleFragment.newInstance("ejemploX",getAquaticAnimals())
    }

    private fun getAquaticAnimals(): ArrayList<Animal> {
        val aquaticAnimals = ArrayList<Animal>()
        aquaticAnimals.add(Animal("Pez payaso", "Descripción del Pez payaso", R.drawable.clown))
        aquaticAnimals.add(Animal("Delfín", "Descripción del Delfín", R.drawable.dolphin))
        aquaticAnimals.add(Animal("Tortuga", "Descripción de la Tortuga", R.drawable.turtle))
        return aquaticAnimals
    }


    private fun getFlyingAnimals(): ArrayList<Animal> {
        val aquaticAnimals = ArrayList<Animal>()
        aquaticAnimals.add(Animal("Búho", "Descripción del Búho", R.drawable.owl))
        aquaticAnimals.add(Animal("Loro", "Descripción del Loro", R.drawable.parrot))
        aquaticAnimals.add(Animal("Paloma", "Descripción de la Paloma ", R.drawable.dove))
        return aquaticAnimals
    }
    private fun getLandAnimals(): ArrayList<Animal> {
        val aquaticAnimals = ArrayList<Animal>()
        aquaticAnimals.add(Animal("Tigre", "Descripción del Tigre", R.drawable.tiger))
        aquaticAnimals.add(Animal("Oso", "Descripción del Oso", R.drawable.bear))
        aquaticAnimals.add(Animal("Perro", "Descripción del Perro", R.drawable.dog))
        return aquaticAnimals
    }

    override fun getCount(): Int {
        return 3
    }

    override fun getPageTitle(position: Int): CharSequence? {
        return "Ejemplo ${position+1}"
    }

}