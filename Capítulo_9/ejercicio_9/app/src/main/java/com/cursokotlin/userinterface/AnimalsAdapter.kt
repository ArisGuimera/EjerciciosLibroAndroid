package com.cursokotlin.userinterface

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.card_animal.view.*

/**
 * Created by Aris on 07/03/2018.
 */
class AnimalsAdapter(
        private val animals: List<Animal>,
        private val onClickItem: (Animal) -> Unit) : RecyclerView.Adapter<AnimalsAdapter.ViewHolder>() {

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = animals[position]
        holder.bind(item, onClickItem)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return ViewHolder(layoutInflater.inflate(R.layout.card_animal, parent, false))
    }

    override fun getItemCount(): Int {
        return animals.size
    }

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        fun bind(animal: Animal, onClickItem: (Animal) -> Unit) {
            itemView.textName.text = animal.name
            itemView.textDescription.text = animal.description
            itemView.imageBackground.setImageResource(animal.image)
            itemView.setOnClickListener { onClickItem(animal) }
        }
    }
}