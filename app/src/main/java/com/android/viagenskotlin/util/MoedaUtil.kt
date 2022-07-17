package com.android.viagenskotlin.util

import java.math.BigDecimal
import java.text.DecimalFormat
import java.util.*

object MoedaUtil {
    private const val PORTUGUES = "pt"
    private const val BRASIL = "br"
    private const val FORMATO_COM_ESPACO = "R$"
    private const val FORMATO_PADRAO = FORMATO_COM_ESPACO

    fun formataParaBrasileiro(valor: BigDecimal?): String {
        val formatoBrasileiro = DecimalFormat.getCurrencyInstance(
            Locale(PORTUGUES, BRASIL)
        )
        return formatoBrasileiro.format(valor)
            .replace(FORMATO_PADRAO, "$FORMATO_COM_ESPACO ")
    }
}