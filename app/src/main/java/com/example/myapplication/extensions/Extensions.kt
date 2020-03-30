package com.example.myapplication.extensions

import android.view.View
import android.widget.TextView
import com.example.myapplication.LogActivity
import com.example.myapplication.MainActivity

fun LogActivity.toast(message: CharSequence, length: Int= android.widget.Toast.LENGTH_SHORT){
    android.widget.Toast.makeText(this, message, length).show()
}

fun LogActivity.onClick(viewId: Int, onClick:(v: android.view.View?)->Unit){
    val view = findViewById<View>(viewId)
    view.setOnClickListener{onClick(it)}
}

fun LogActivity.getTextString(id: Int):String{
    val textView = findViewById<TextView>(id)
    return textView.text.toString()
}