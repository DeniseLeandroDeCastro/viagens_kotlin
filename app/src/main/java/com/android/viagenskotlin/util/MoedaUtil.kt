package com.android.viagenskotlin.util

import java.math.BigDecimal
import java.text.DecimalFormat
import java.util.*

class MoedaUtil {

    companion object {
        fun formataParaBrasileiro(valor: BigDecimal?): String {
            val formatoBrasileiro = DecimalFormat.getCurrencyInstance(
                Locale("pt", "br")
            )
            return formatoBrasileiro.format(valor).replace("R$", "R$ ")
        }
    }
}