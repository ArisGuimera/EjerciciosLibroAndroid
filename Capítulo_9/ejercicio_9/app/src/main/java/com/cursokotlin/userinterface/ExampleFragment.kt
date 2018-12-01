package com.cursokotlin.userinterface

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import kotlinx.android.synthetic.main.fragment_example.*
import java.io.Serializable
import java.util.ArrayList

class ExampleFragment : Fragment() {

    lateinit var adapter:AnimalsAdapter
    private var title: String = ""
    lateinit private var animals:ArrayList<Animal>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if (arguments != null) {
            title = arguments.getString(ARG_TITLE)
            animals = arguments.getSerializable(ARG_ANIMALS) as ArrayList<Animal>
        }
    }

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        return inflater!!.inflate(R.layout.fragment_example, container, false)
    }



    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        configureView()
    }

    private fun configureView() {
        textTitle.text = title
        setUpRecyclerView(animals)
    }

     private fun showAnimalSelected(animal: Animal){
        Toast.makeText(activity, "El animal seleccionado es ${animal.name}", Toast.LENGTH_SHORT).show()
    }

    private fun setUpRecyclerView(animals: ArrayList<Animal>) {
        adapter = AnimalsAdapter(animals, {showAnimalSelected(it)})
        rvAnimals.layoutManager = LinearLayoutManager(activity)
        rvAnimals.adapter = adapter
    }


    companion object {
        private val ARG_TITLE = "ARG_TITLE"
        private val ARG_ANIMALS = "ARG_ANIMALS"

        fun newInstance(title: String,animals: ArrayList<Animal>): ExampleFragment{
            val fragment = ExampleFragment()
            val args = Bundle()
            args.putString(ARG_TITLE, title)
            args.putSerializable(ARG_ANIMALS, animals as Serializable)
            fragment.arguments = args
            return fragment
        }
    }
}
