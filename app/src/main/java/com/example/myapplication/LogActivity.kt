package com.example.myapplication

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log

open class LogActivity : AppCompatActivity(){
    private val TAG = "informacoes_de_tela"
    // Nome da classe sem o pacote
    private val className: String
        get() {
            val s = javaClass.name
            return s.substring(s.lastIndexOf("."))
        }

    override fun onCreate(icicle: Bundle?) {
        super.onCreate(icicle)
        Log.i(TAG, className + ".onCreate() chamado: " + icicle)
    }

    override fun onStart() {
        super.onStart()
        Log.i(TAG, className + ".onStart() chamado.")
    }

    override fun onRestart() {
        super.onRestart()
        Log.i(TAG, className + ".onRestart() chamado.")
    }

    override fun onResume() {super.onResume()
        Log.i(TAG, className + ".onResume() chamado.")
    }

    override fun onPause() {
        super.onPause()
        Log.i(TAG, className + ".onPause() chamado.")
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        Log.i(TAG, className + ".onSaveInstanceState() chamado.")
    }

    override fun onStop() {
        super.onStop()
        Log.i(TAG, className + ".onStop() chamado.")
    }

    override fun onDestroy() {super.onDestroy()
        Log.i(TAG, className + ".onDestroy() chamado.")
    }
}