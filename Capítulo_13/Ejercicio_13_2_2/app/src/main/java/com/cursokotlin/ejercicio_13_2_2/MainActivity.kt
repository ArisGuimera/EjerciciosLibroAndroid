package com.cursokotlin.ejercicio_13_2_2

import android.Manifest
import android.content.pm.PackageManager
import android.os.Bundle
import android.os.Environment
import android.support.v4.app.ActivityCompat
import android.support.v4.content.ContextCompat
import android.support.v7.app.AppCompatActivity
import android.util.Log
import java.io.File
import java.io.FileInputStream

class MainActivity : AppCompatActivity() {

	private val TAG = "ExternalStorageDemo"
	private val RECORD_REQUEST_CODE = 101

	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		setContentView(R.layout.activity_main)
		setupPermissions()
	}

	fun isExternalStorageWritable(): Boolean {
		return Environment.getExternalStorageState() == Environment.MEDIA_MOUNTED
	}

	fun isExternalStorageReadable(): Boolean {
		return Environment.getExternalStorageState() in setOf(
			Environment.MEDIA_MOUNTED,
			Environment.MEDIA_MOUNTED_READ_ONLY
		)
	}

	override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<out String>, grantResults: IntArray) {
		super.onRequestPermissionsResult(requestCode, permissions, grantResults)

		if (requestCode == RECORD_REQUEST_CODE){
			if(grantResults[0] == PackageManager.PERMISSION_GRANTED){
				Log.i(TAG,"Permiso aceptado")
				readWriteExternalStorage()
			}else{
				Log.i(TAG,"Permiso rechazado")
				makeRequest()
			}
		}
	}

	private fun setupPermissions(){
		val permission = ContextCompat.checkSelfPermission(this, Manifest.permission.WRITE_EXTERNAL_STORAGE)

		if (permission != PackageManager.PERMISSION_GRANTED){
			Log.i(TAG, "El permiso no está aceptado")
			makeRequest()
		}else{
			readWriteExternalStorage()
		}
	}

	private fun makeRequest(){
		ActivityCompat.requestPermissions(this, arrayOf(Manifest.permission.WRITE_EXTERNAL_STORAGE), RECORD_REQUEST_CODE)
	}

	private fun readWriteExternalStorage(){
		if(isExternalStorageReadable() && isExternalStorageWritable()){
			val textFile = getPrivateStorage("MyExampleTextFile.txt")
			textFile?.run{
				appendText("Example title")
				appendText("Example subtitle")
				appendText("Example body")
			}

			val inputAsString = FileInputStream(textFile).bufferedReader().use{
				it.readText()
			}
			Log.i(TAG, inputAsString)
		}
	}

	private fun getPrivateStorage(fileName:String): File?{
		return File(getExternalFilesDir(Environment.DIRECTORY_PICTURES), fileName)
	}

	private fun deleteFile(file:File?) {
		file?.delete()
	}

	private fun exist(file:File?):Boolean{
		file?.let {
			return it.exists()
		}
		return false
	}


}
