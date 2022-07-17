package com.android.viagenskotlin.ui.adapter

import android.content.Context
import android.graphics.drawable.Drawable
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView
import com.android.viagenskotlin.R
import com.android.viagenskotlin.model.Pacote
import com.android.viagenskotlin.util.DiasUtil
import com.android.viagenskotlin.util.MoedaUtil
import com.android.viagenskotlin.util.ResourcesUtil


class ListaDePacotesAdapter(private val pacotes: List<Pacote>, private val context: Context) :
    BaseAdapter() {

    override fun getCount(): Int {
        return pacotes.size
    }

    override fun getItem(posicao: Int): Any {
        return pacotes[posicao]
    }

    override fun getItemId(i: Int): Long {
        return 0
    }

    override fun getView(posicao: Int, view: View?, parent: ViewGroup?): View? {
        val viewCriada = LayoutInflater.from(context)
            .inflate(R.layout.item_pacote, parent, false)
        val pacote = pacotes[posicao]
        mostraLocal(viewCriada, pacote)
        mostraImagem(viewCriada, pacote)
        mostraDias(viewCriada, pacote)
        mostraPreco(viewCriada, pacote)
        return viewCriada
    }

    private fun mostraPreco(viewCriada: View, pacote: Pacote) {
        val preco = viewCriada.findViewById<TextView>(R.id.item_pacote_preco)
        val moedaBrasileira = MoedaUtil
            .formataParaBrasileiro(pacote.preco)
        preco.text = moedaBrasileira
    }

    private fun mostraDias(viewCriada: View, pacote: Pacote) {
        val dias = viewCriada.findViewById<TextView>(R.id.item_pacote_dias)
        val diasEmTexto: String = DiasUtil.formataEmTexto(pacote.dias)
        dias.text = diasEmTexto
    }

    private fun mostraImagem(viewCriada: View, pacote: Pacote) {
        val imagem = viewCriada.findViewById<ImageView>(R.id.item_pacote_imagem)
        val drawableImagemPacote: Drawable =
            ResourcesUtil.devolveDrawable(context, pacote.imagem)
        imagem.setImageDrawable(drawableImagemPacote)
    }

    private fun mostraLocal(viewCriada: View, pacote: Pacote) {
        val local = viewCriada.findViewById<TextView>(R.id.item_pacote_local)
        local.setText(pacote.local)
    }
}