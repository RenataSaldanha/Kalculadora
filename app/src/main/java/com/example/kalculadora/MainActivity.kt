package com.example.kalculadora

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    var operador: Int = 0
    var numero: Double = 0.0
    lateinit var txtConta: TextView
    lateinit var txtResultado: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Para esconder a toolbar
        supportActionBar!!.hide()

        // Declarar textView da conta e do resultado
        txtConta = findViewById(R.id.txt_conta)
        txtResultado = findViewById(R.id.txt_resultado)


        // Declarar botões limpar, apagar e igual
        var btnLimpar = findViewById<TextView>(R.id.btnLimpar)
        var btnApagar = findViewById<ImageView>(R.id.btnApagar)
        var btnIgual = findViewById<TextView>(R.id.btnIgual)


        // Botão para apagar todos os campos de uma vez
        btnLimpar.setOnClickListener {
            txtConta.text = ""
            txtResultado.text = ""
        }


        // Botão para apagar um a um dos números digitados
        btnApagar.setOnClickListener {
            val string= txtResultado.text.toString()

            if (string.isNotBlank()){
                txtResultado.text = string.substring(0, string.length - 1)
            }
        }

        // Botão para apresentar a conta
        btnIgual.setOnClickListener {

            // Variavel numero1 vai receber os valores que estão no txtResultado (inicialmente no num1) depois do operador ser selecionado
            var numero1: Double = txtResultado.text.toString().toDouble()

            // variavel resposta vai armazenar nossos resultados das operações
            var resposta: Double = 0.0

            when (operador) {
                1 -> resposta = numero + numero1
                2 -> resposta = numero - numero1
                3 -> resposta = numero * numero1
                4 -> resposta = numero / numero1
            }

            // txtResultado mostrará o resultado
            txtResultado.setText(resposta.toString())

            // txtConta será zerada
            txtConta.setText("")

        }
    }


    fun adicionarNumero(view: View) {

        // Variável num1 vai receber o que está em txtResultado que inicialmente será nada
        var num1: String = txtResultado.text.toString()

        // Variável num1 vai receber o o que está em txtResultado + o valor do botão em forma de string, e irá concatenar todos os outros números que forem adicionados
        when (view.id) {
            R.id.num0 -> txtResultado.setText(num1 + "0")
            R.id.num1 -> txtResultado.setText(num1 + "1")
            R.id.num2 -> txtResultado.setText(num1 + "2")
            R.id.num3 -> txtResultado.setText(num1 + "3")
            R.id.num4 -> txtResultado.setText(num1 + "4")
            R.id.num5 -> txtResultado.setText(num1 + "5")
            R.id.num6 -> txtResultado.setText(num1 + "6")
            R.id.num7 -> txtResultado.setText(num1 + "7")
            R.id.num8 -> txtResultado.setText(num1 + "8")
            R.id.num9 -> txtResultado.setText(num1 + "9")
            R.id.btnPonto -> txtResultado.setText(num1 + ".")
        }
    }


    fun pegarOperador(view: View) {

        // Variavel numero vai pegar o que esta contido no txtResultado, depois de ter sido digitado no num1, transformar para double e armazenar
        numero = txtResultado.text.toString().toDouble()

        // Variavel num2 vai pegar o que esta em txtResultado, que no caso será o valor digitado em num1 em formato de string e adicionar a string do operador
        var num2: String = txtResultado.text.toString()

        when (view.id) {
            // Se for cliado no botão de adicionar, a variavel num2 receberá a string "+", e o valor do operador será 1
            R.id.btnAdicionar -> {
                txtConta.setText(num2 + "+")
                operador = 1
            }

            // Se for cliado no botão de subtrair, a variavel num2 receberá a string "-", e o valor do operador será 2
            R.id.btnSubtrair -> {
                txtConta.setText(num2 + "-")
                operador = 2
            }

            // Se for cliado no botão de multiplicar, a variavel num2 receberá a string "x", e o valor do operador será 3
            R.id.btnMultiplicar -> {
                txtConta.setText(num2 + "x")
                operador = 3
            }

            // Se for cliado no botão de dividir, a variavel num2 receberá a string "/", e o valor do operador será 4
            R.id.btnDividir -> {
                txtConta.setText(num2 + "/")
                operador = 4
            }
        }

        // Zerará o txtResultado que o primeiro numero digitado concatenado com a string do operador ir pro txtConta
        txtResultado.setText("")
    }

}