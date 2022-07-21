package com.android.viagenskotlin.ui.activity

import android.content.Intent
import android.os.Bundle
import android.widget.ListView
import androidx.appcompat.app.AppCompatActivity
import com.android.viagenskotlin.R
import com.android.viagenskotlin.dao.PacoteDAO
import com.android.viagenskotlin.model.Pacote
import com.android.viagenskotlin.ui.adapter.ListaDePacotesAdapter

class ListaPacotesActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lista_pacotes)

        title = TITULO_APPBAR
        configuraLista()

        val intent = Intent(this, ResumoPacoteActivity::class.java)
        startActivity(intent)
    }

    private fun configuraLista() {
        val listaDePacotes = findViewById<ListView>(R.id.lista_pacotes_listview)
        val pacotes = PacoteDAO().lista()
        listaDePacotes.adapter = ListaDePacotesAdapter(pacotes as List<Pacote>, this)
    }

    companion object {
        const val TITULO_APPBAR = "Pacotes Viagens RN"
    }
}