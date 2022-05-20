package com.example.kalculadora

import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.kalculadora.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private var operador: String = ""
    private var primeiroValor: Double = 0.0
    private lateinit var txtConta: TextView
    private lateinit var txtResultado: TextView

    private val binding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        supportActionBar!!.hide()

        txtConta = binding.txtConta
        txtResultado = binding.txtResultado

        val btnLimpar = binding.btnLimpar
        val btnApagar = binding.btnApagar
        val btnIgual = binding.btnIgual

        btnLimpar.setOnClickListener {
            Calculadora().limpar(
                txtConta = txtConta,
                txtResultado = txtResultado
            )
        }

        btnApagar.setOnClickListener {
            Calculadora().apagar(
                txtResultado = txtResultado
            )
        }

        btnIgual.setOnClickListener {
            Calculadora().calcular(
                txtResultado = txtResultado,
                txtConta = txtConta,
                primeiroValor = primeiroValor,
                operador = operador
            )

        }

    }

    fun adicionarNumero(view: View) {

        val adicionarNumeros: String = txtResultado.text.toString()

        when (view.id) {
            R.id.num0 -> txtResultado.text = adicionarNumeros + "0"
            R.id.num1 -> txtResultado.text = adicionarNumeros + "1"
            R.id.num2 -> txtResultado.text = adicionarNumeros + "2"
            R.id.num3 -> txtResultado.text = adicionarNumeros + "3"
            R.id.num4 -> txtResultado.text = adicionarNumeros + "4"
            R.id.num5 -> txtResultado.text = adicionarNumeros + "5"
            R.id.num6 -> txtResultado.text = adicionarNumeros + "6"
            R.id.num7 -> txtResultado.text = adicionarNumeros + "7"
            R.id.num8 -> txtResultado.text = adicionarNumeros + "8"
            R.id.num9 -> txtResultado.text = adicionarNumeros + "9"
            R.id.btnVirgula -> txtResultado.text = "$adicionarNumeros."
        }
    }


    fun pegarOperador(view: View) {

        val semNada = txtResultado.text
        if (semNada == "") {
            txtResultado.text = "0"
            txtConta.text = "0"
        }

        primeiroValor = txtResultado.text.toString().toDouble()

        val primeiroValorString: String = txtResultado.text.toString()

        when (view.id) {
            R.id.btnAdicionar -> {
                txtConta.text = "$primeiroValorString+"
                operador = "+"
            }
            R.id.btnSubtrair -> {
                txtConta.text = "$primeiroValorString-"
                operador = "-"
            }
            R.id.btnMultiplicar -> {
                txtConta.text = primeiroValorString + "x"
                operador = "x"
            }
            R.id.btnDividir -> {
                txtConta.text = "$primeiroValorString/"
                operador = "/"
            }
        }
        txtResultado.text = ""
    }

}