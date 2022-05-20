package com.example.kalculadora

import android.widget.TextView

class Calculadora {
    fun calcular(
        txtResultado: TextView,
        txtConta: TextView,
        primeiroValor: Double,
        operador: String,
    ) {

        val semNada = txtResultado.text
        if (semNada == "") {
            txtResultado.text = "0"
        }

        val segundoValor: Double = txtResultado.text.toString().toDouble()

        var respostaOperacao = 0.0

        when (operador) {
            "+" -> respostaOperacao = primeiroValor + segundoValor
            "-" -> respostaOperacao = primeiroValor - segundoValor
            "x" -> respostaOperacao = primeiroValor * segundoValor
            "/" -> respostaOperacao = primeiroValor / segundoValor
        }

        txtResultado.text = respostaOperacao.toString()
        txtConta.text = ""
    }

    fun apagar(txtResultado: TextView) {
        val string = txtResultado.text.toString()
        if (string.isNotBlank()) {
            txtResultado.text = string.substring(0, string.length - 1)
        }
    }

    fun limpar(txtConta: TextView, txtResultado: TextView) {
        txtConta.text = ""
        txtResultado.text = ""
    }
}