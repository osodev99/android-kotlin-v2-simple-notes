package com.codebear.simpletakenotes

import android.os.Bundle
import android.util.Log
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

const val TAG = "Simple Take Notes"

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val pantallaAoc = Pantalla(
            tamanioPulgadas = 32.0,
            id = 2,
            marca = "AOC",
            priceBuy = 1200.0,
            priceSell = 1750.0
        )

        val tecladoUno = Teclado(
            tipoKey = "ES",
            marca = "Delius",
            priceBuy = 80.0,
            priceSell = 120.0,
            accesorios = listOf("letras de repuesto", "baterias", "conector usb")
        )

        pantallaAoc.showInfo()
        tecladoUno.showInfo()
    }
}

open class Componente(
    val marca: String,
    protected val priceBuy: Double,
    val priceSell: Double
) {
    open fun showInfo(): Unit {
        Log.e(TAG, "showInfo: $marca, $priceBuy, $priceSell")
    }
}

class Pantalla(
    val id: Int,
    val tamanioPulgadas: Double,
    marca: String,
    priceBuy: Double,
    priceSell: Double,
) : Componente(marca, priceBuy, priceSell) {
    override fun showInfo() {
        Log.e(TAG, "Pantalla: $id, $priceBuy, $marca, $priceSell")
    }
}

class Teclado(
    val tipoKey: String,
    val accesorios: List<String>,
    marca: String,
    priceBuy: Double,
    priceSell: Double,
) : Componente(marca, priceBuy, priceSell) {
    override fun showInfo() {
        Log.e(TAG, "Teclado: $marca, $priceBuy, $priceSell")
    }
}