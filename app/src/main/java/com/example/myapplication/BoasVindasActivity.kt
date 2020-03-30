package com.example.myapplication

import android.content.Context
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.Toolbar
import android.view.Menu
import android.view.MenuItem
import android.widget.TextView

import android.support.v4.view.MenuItemCompat
import com.example.myapplication.extensions.getTextString
import com.example.myapplication.extensions.onClick
import com.example.myapplication.extensions.toast


class BoasVindasActivity : LogActivity() {

    private val context: Context get() = this
    private var nome: String? = ""
    override fun onCreate(icicle: Bundle?) {
        super.onCreate(icicle)
        setContentView(R.layout.activity_boas_vindas)


        val textView = findViewById<TextView>(R.id.textView_boas_vindas)
        val args = intent.extras
        nome = args?.getString("nome")
        textView.text = getString(R.string.welcome, nome)

        val toolbar = findViewById<Toolbar>(R.id.toolbar)
        setSupportActionBar(toolbar)


//        supportActionBar?.title = "Olá sou Action Bar de appCompat"
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        //Infla os menus com os botões do action bar
//        menu?.getItem(R.id.action_sair)?.setVisible(false)
//        menu?.getItem(R.id.action_confirmar)?.setVisible(false)
//        menu?.getItem(R.id.action_cancelar)?.setVisible(false)
//        menu?.getItem(R.id.action_ver_pedido)?.setVisible(false)

        menuInflater.inflate(R.menu.menu_principal, menu)
        return super.onCreateOptionsMenu(menu)
    }
    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        val id = item?.itemId
        if (id == R.id.action_add){
            val intent = Intent(context, PedidosActivity::class.java)
            val params = Bundle()
            params.putString("nome", nome)
            intent.putExtras(params)
            startActivity(intent)
            return true
        }
//        else if (id == android.R.id.home){
//            toast("Clicou em Voltar")
//            return true;
//        }
        return super.onOptionsItemSelected(item)
    }

}
