package com.uvg.taller4

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    var cantidadatos = 1
    private var adaptador = Adaptador({
        clickListener -> showItemClick(clickListener)
    },
            {
                longClickListener -> changeItemClick(longClickListener)
            })
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val items: MutableList<String> = mutableListOf()

        while(cantidadatos <= 10){
            items.add("Prueba $cantidadatos")
            cantidadatos++
        }

        btnAgregar.setOnClickListener(){
            items.add("Prueba $cantidadatos")
            cantidadatos++
            adaptador.setItems(items)
        }
        //btnAgregar.onKeyLongPress()


        adaptador.setItems(items)
        lista.layoutManager = LinearLayoutManager(this)
        lista.adapter = adaptador
    }

    private fun showItemClick(position: Int){
        adaptador.deleteItem(position)

    }

    private fun changeItemClick(position: Int){
        adaptador.setItem(position)
        val item = adaptador.getItem(position)
        Toast.makeText(this,item,Toast.LENGTH_SHORT).show()

    }



}