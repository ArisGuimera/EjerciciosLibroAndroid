package com.cursokotlin.animallist

import android.media.Image
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Filter
import android.widget.Filterable
import android.widget.ImageView
import kotlinx.android.synthetic.main.card_animal.view.*

/**
 * Created by aristidesguimeraorozco on 10/3/18.
 */

class AnimalsAdapter(
        val animalList: AnimalsList, val onClickAnimal: (Animal, ImageView) -> Unit) : RecyclerView.Adapter<AnimalsAdapter.ViewHolder>(){

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = animalList.animals[position]
        holder.bind(item, onClickAnimal)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return ViewHolder(layoutInflater.inflate(R.layout.card_animal, parent, false))
    }

    override fun getItemCount(): Int {
        return animalList.animals.size
    }

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        fun bind(animal: Animal, onClickAnimal: (Animal, ImageView) -> Unit) {
            itemView.setOnClickListener { onClickAnimal(animal, itemView.imageBackground) }
            itemView.textName.text = animal.name
            itemView.imageBackground.loadUrl(animal.image)
        }
    }
}
