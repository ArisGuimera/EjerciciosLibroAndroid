package com.cursokotlin.ejercicio_15_4_1

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView

/**
 * Created by aristidesguimeraorozco on 04/11/2018.
 */
internal class RecyclerAdapter(
        private val simpleList:ArrayList<String>,
        private val openDetail:(ImageView) -> Unit):RecyclerView.Adapter<RecyclerAdapter.ViewHolder>(){

    override fun onBindViewHolder(holder: ViewHolder?, position: Int) {
        val item = simpleList[position]
        holder?.bind(item, position, openDetail)
    }

    override fun getItemCount(): Int {
        return simpleList.size
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder{
        val layoutInflater = LayoutInflater.from(parent.context)
        return ViewHolder(layoutInflater.inflate(R.layout.item_recycler, parent, false))
    }

    internal class ViewHolder(view:View) : RecyclerView.ViewHolder(view){
        val title: TextView = view.findViewById(R.id.textTitle)
        val imageDefault: ImageView = view.findViewById(R.id.imageDefault)
        val body: TextView = view.findViewById(R.id.textBody)
        fun bind (desception: String, position: Int, openDetail: (ImageView) -> Unit){
            title.text = "Título $position"
            body.text = desception
            itemView.setOnClickListener { openDetail(imageDefault) }
        }
    }
}