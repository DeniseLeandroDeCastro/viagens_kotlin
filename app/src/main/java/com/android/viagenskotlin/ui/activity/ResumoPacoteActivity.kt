package com.android.viagenskotlin.ui.activity

import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.android.viagenskotlin.R
import com.android.viagenskotlin.model.Pacote
import com.android.viagenskotlin.util.DataUtil
import com.android.viagenskotlin.util.DiasUtil
import com.android.viagenskotlin.util.MoedaUtil
import com.android.viagenskotlin.util.ResourcesUtil
import java.math.BigDecimal
import java.text.SimpleDateFormat
import java.util.*

class ResumoPacoteActivity : AppCompatActivity() {

    val TITULO_APPBAR = "Resumo do pacote"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_resumo_pacote)
        title = TITULO_APPBAR
        val pacoteNatal = Pacote(
            "Praia de Pirangi", "pirangi", 2, BigDecimal("243.99")
        )
        mostraLocal(pacoteNatal)
        mostraImagem(pacoteNatal)
        mostraDias(pacoteNatal)
        mostraPreco(pacoteNatal)
        mostraData(pacoteNatal)
    }

    private fun mostraData(pacote: Pacote) {
        val data = findViewById<TextView>(R.id.resumo_pacote_data)
        DataUtil.periodoEmTexto(pacote.dias)
    }

    private fun mostraPreco(pacote: Pacote) {
        val preco = findViewById<TextView>(R.id.resumo_pacote_preco)
        val moedaBrasileira = MoedaUtil.formataParaBrasileiro(pacote.preco)
        preco.text = moedaBrasileira
    }

    private fun mostraDias(pacote: Pacote) {
        val dias = findViewById<TextView>(R.id.resumo_pacote_dias)
        val diasEmTexto = DiasUtil.formataEmTexto(pacote.dias)
        dias.text = diasEmTexto
    }

    private fun mostraImagem(pacote: Pacote) {
        val imagem = findViewById<ImageView>(R.id.resumo_pacote_imagem)
        val drawableDoPacote = ResourcesUtil.devolveDrawable(
            this, pacote.imagem
        )
        imagem.setImageDrawable(drawableDoPacote)
    }

    private fun mostraLocal(pacote: Pacote) {
        val local = findViewById<TextView>(R.id.resumo_pacote_local)
        local.setText(pacote.local)
    }
}
