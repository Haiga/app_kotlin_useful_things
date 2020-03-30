package com.example.myapplication

import android.content.Context
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.Toolbar
import android.view.Menu
import android.view.MenuItem
import android.widget.TextView
import com.example.myapplication.extensions.getTextString
import com.example.myapplication.extensions.onClick

class PedidosActivity : LogActivity() {

    private val context: Context get() = this
    private var nome: String? = ""
    override fun onCreate(icicle: Bundle?) {
        super.onCreate(icicle)
        setContentView(R.layout.activity_pedidos)

        val args = intent.extras
        nome = args?.getString("nome")

        val toolbar = findViewById<Toolbar>(R.id.toolbar)
        setSupportActionBar(toolbar)

        supportActionBar?.title = ""
//        supportActionBar?.setDisplayHomeAsUpEnabled(true)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        //Infla os menus com os botões do action bar
        menuInflater.inflate(R.menu.menu_principal, menu)
        return super.onCreateOptionsMenu(menu)
    }
    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        val id = item?.itemId
        if (id == R.id.action_ver_pedido){
            val intent = Intent(context, ConfirmacaoPedidosActivity::class.java)
            val params = Bundle()

            val produto =  getTextString(R.id.text_produto)
            val valor = getTextString(R.id.text_valor)
            val qtde = getTextString(R.id.text_quantidade)
//
            params.putString("nome", nome)
            params.putString("produto", produto)
            params.putString("valor", valor)
            params.putString("qtde", qtde)

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
