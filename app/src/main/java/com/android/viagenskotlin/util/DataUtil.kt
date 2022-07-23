package com.android.viagenskotlin.util

import java.text.SimpleDateFormat
import java.util.*

object DataUtil {

    const val DIA_E_MES = "dd/MM"

    fun periodoEmTexto(dias: Int): String {
        val dataIda = Calendar.getInstance()
        val dataVolta = Calendar.getInstance()
        dataVolta.add(Calendar.DATE, dias)
        val formatoBrasileiro = SimpleDateFormat(DIA_E_MES)
        val dataFormatadaIda = formatoBrasileiro.format(dataIda.time)
        val dataFormatadaVolta = formatoBrasileiro.format(dataVolta.time)
        return (dataFormatadaIda + "-"
                + dataFormatadaVolta
                + "de " + dataVolta[Calendar.YEAR])
    }
}