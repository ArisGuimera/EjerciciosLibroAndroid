package com.cursokotlin.ejercicio_8_6


import android.content.Context
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.fragment_color.*

class ColorFragment : Fragment() {

    lateinit var myCallback:ColorFragment.Callback

    interface Callback{
        fun onClickButton()
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_color, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        buttonFragment.setOnClickListener { myCallback.onClickButton() }
    }

    override fun onAttach(context: Context?) {
        super.onAttach(context)
        try {
            myCallback = context as Callback
        } catch (e : ClassCastException) {
            throw (ClassCastException (context?.toString()
                + " must implement Callback"))
        }
    }
}
