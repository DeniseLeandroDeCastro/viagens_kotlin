package com.android.viagenskotlin.ui.activity

import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.android.viagenskotlin.R
import com.android.viagenskotlin.model.Pacote
import com.android.viagenskotlin.util.DiasUtil
import com.android.viagenskotlin.util.MoedaUtil
import com.android.viagenskotlin.util.ResourcesUtil
import java.math.BigDecimal
import java.text.SimpleDateFormat
import java.util.*

class ResumoPacoteActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_resumo_pacote)

        title = "Resumo do pacote"

        val pacoteNatal = Pacote(
            "Praia de Pirangi", "pirangi", 2, BigDecimal("243.99")
        )

        val local = findViewById<TextView>(R.id.resumo_pacote_local)
        local.setText(pacoteNatal.local)

        val imagem = findViewById<ImageView>(R.id.resumo_pacote_imagem)
        val drawableDoPacote = ResourcesUtil.devolveDrawable(
            this, pacoteNatal.imagem
        )
        imagem.setImageDrawable(drawableDoPacote)

        val dias = findViewById<TextView>(R.id.resumo_pacote_dias)
        val diasEmTexto = DiasUtil.formataEmTexto(pacoteNatal.dias)
        dias.text = diasEmTexto

        val preco = findViewById<TextView>(R.id.resumo_pacote_preco)
        val moedaBrasileira = MoedaUtil.formataParaBrasileiro(pacoteNatal.preco)
        preco.text = moedaBrasileira

        val data = findViewById<TextView>(R.id.resumo_pacote_data)
        val dataIda = Calendar.getInstance()
        val dataVolta = Calendar.getInstance()
        dataVolta.add(Calendar.DATE, pacoteNatal.dias)
        val formatoBrasileiro = SimpleDateFormat("dd/MM")
        val dataFormatadaIda = formatoBrasileiro.format(dataIda.time)
        val dataFormatadaVolta = formatoBrasileiro.format(dataVolta.time)
        val dataFormatadaDaViagem = (dataFormatadaIda + "-"
                + dataFormatadaVolta
                + "de " + dataVolta[Calendar.YEAR])
        data.text = dataFormatadaDaViagem
    }
}
