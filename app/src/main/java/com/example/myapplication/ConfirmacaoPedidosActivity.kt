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
import com.example.myapplication.extensions.toast

class ConfirmacaoPedidosActivity : LogActivity() {

    private val context: Context get() = this
    private var nome: String? = ""
    override fun onCreate(icicle: Bundle?) {
        super.onCreate(icicle)
        setContentView(R.layout.activity_confirmacao_pedidos)

        val args = intent.extras
        nome = args?.getString("nome")
        val produto = args?.getString("produto")
        val valor = args?.getString("valor")
        val qtde = args?.getString("qtde")


        val textView2 = findViewById<TextView>(R.id.textv_produto)
        textView2.text = produto

        val textView3 = findViewById<TextView>(R.id.textv_valor)
        textView3.text = valor

        val textView4 = findViewById<TextView>(R.id.textv_qtde)
        textView4.text = qtde

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
        if (id == R.id.action_cancelar){
            super.onBackPressed()
            return true
        }else if(id == R.id.action_confirmar){
            val intent = Intent(context, BoasVindasActivity::class.java)
            val params = Bundle()
            params.putString("nome", nome)
            intent.putExtras(params)
            toast("Pedido Confirmado com Sucesso!", android.widget.Toast.LENGTH_LONG)
            startActivity(intent)
            return true
        }else if (id == R.id.action_sair){
            super.onDestroy()
        }
        return super.onOptionsItemSelected(item)
    }

}
