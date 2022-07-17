package com.android.viagenskotlin.util

object DiasUtil {
    const val SINGULAR = "dia"
    const val PLURAL = SINGULAR + "s"
    fun formataEmTexto(quantidadeDeDias: Int): String {
        return if (quantidadeDeDias > 1) {
            "$quantidadeDeDias $PLURAL"
        } else "$quantidadeDeDias $SINGULAR"
    }
}