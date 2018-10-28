package com.cursokotlin.ejercicio_13_2_1

import android.content.Context
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.cursokotlin.ejercicio_13_2.R
import java.io.File
import java.io.InputStream

class MainActivity : AppCompatActivity() {

    val fileName  = "test_file.txt"
    lateinit var file:File

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initInternalPersistence()
        readInternalFile()
        deleteFile()
    }

    private fun initInternalPersistence(){
        file = File(filesDir, fileName)
        val fos = openFileOutput(fileName, Context.MODE_PRIVATE)
        fos.write("primera línea".toByteArray())
        fos.write("segunda línea".toByteArray())
        fos.write("tercera línea".toByteArray())
        fos.write("cuarta línea".toByteArray())
        fos.write("quinta línea".toByteArray())
        fos.close()
    }

    private fun readInternalFile(){
        val inputStream:InputStream = file.inputStream()
        val inputString = inputStream.bufferedReader().use { it.readText() }
        Log.v("Result", inputString)
    }

    private fun deleteFile(){
        file.delete()
    }
}
