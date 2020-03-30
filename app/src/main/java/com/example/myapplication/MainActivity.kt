package com.example.myapplication

import android.content.Context
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.Toolbar
import android.view.Menu
import com.example.myapplication.extensions.getTextString
import com.example.myapplication.extensions.onClick
import com.example.myapplication.extensions.toast

class MainActivity : LogActivity() {


    private val context: Context get() = this
    override fun onCreate(icicle: Bundle?) {
        super.onCreate(icicle)
        setContentView(R.layout.activity_main)

        onClick(R.id.button_login){
            onClickLogin()
        }

    }

    fun onClickLogin(){

        val login =  getTextString(R.id.text_login)
        val senha = getTextString(R.id.text_pwd)
        if (login == "aluno" && senha == "123") {

            val intent = Intent(context, BoasVindasActivity::class.java)
            val params = Bundle()
            params.putString("nome", "aluno")
            intent.putExtras(params)
            startActivity(intent)
        }
        else {
            toast("Login ou Senha incorretos!!")
        }
    }
}
