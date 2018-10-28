package com.cursokotlin.ejercicio_12

import android.content.Context
import android.os.AsyncTask
import android.util.Log
import android.widget.Toast

/**
 * Created by aristidesguimeraorozco on 28/10/2018.
 */
class SleepClass:AsyncTask<Context, Void, Context>() {

    private val TAG = "AsyncTask"

    override fun doInBackground(vararg params: Context?): Context {
        Thread.sleep(5000)
        return params[0]!!
    }

    override fun onPreExecute() {
        super.onPreExecute()
        Log.i(TAG, "Iniciando el hilo")
    }

    override fun onPostExecute(result: Context?) {
        super.onPostExecute(result)
        Toast.makeText(result, "Han pasado 5 segundos", Toast.LENGTH_SHORT).show()
    }
}