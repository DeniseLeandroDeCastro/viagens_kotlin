package com.android.viagenskotlin.dao

import com.android.viagenskotlin.model.Pacote
import java.math.BigDecimal
import java.util.*
import kotlin.collections.ArrayList


class PacoteDAO {

    fun lista(): List<Pacote?>? {
        return ArrayList(
            Arrays.asList(
                Pacote("Praia de Pirangi/RN", "pirangi", 2, BigDecimal(243.99)),
                Pacote("Cajueiro de Pirangi/RN", "cajueiro", 3, BigDecimal(421.50)),
                Pacote("Praia de Maracajaú/RN", "maracajau", 4, BigDecimal(754.20)),
                Pacote("Praia de Pirangi do Norte/RN", "pirangi_do_norte", 4, BigDecimal(754.20)),
                Pacote("Praia de Ponta Negra/RN", "ponta_negra", 6, BigDecimal(532.55)),
                Pacote("raia de Cotovelo/RN", "praia_de_cotovelo", 5, BigDecimal(899.99)),
                Pacote("Praia de Pipa/RN", "praia_de_pipa", 1, BigDecimal(289.90)),
                Pacote("Praia de Santa Rita/RN", "praia_sta_rita", 1, BigDecimal(289.90))
            )
        )
    }
}