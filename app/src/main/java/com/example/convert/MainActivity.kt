package com.example.convert

import android.R
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*
import com.example.convert.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        val binding = ActivityMainBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        val spinner1 = binding.spinner1
        val spinner2 = binding.spinner2
        val result = binding.result
        val number = binding.number
        val btn = binding.btn

        val types = listOf("Pesos","Dollar","Euro")
        val adaptador = ArrayAdapter(this@MainActivity,
            R.layout.simple_list_item_1, types
        )
        spinner1.adapter = adaptador
        spinner2.adapter = adaptador
        btn.setOnClickListener {
            var final = 0.0
            val amount = number.text.toString().toDouble()
            val current = spinner1.selectedItem.toString()
            val after = spinner2.selectedItem.toString()
            when(current){
                "Pesos"->{
                    if (after== "Dollar"){
                        final = amount*0.050
                    }else if(after=="Euro"){
                        final = amount*0.051
                    }else{
                        final = amount
                    }
                }
                "Dollar"->{
                    if (after== "Peso"){
                        final = amount*20.07
                    }else if(after=="Euro"){
                        final = amount*1.03
                    }else{
                        final = amount
                    }
                }
                "Euro"->{
                    if (after== "Dollar"){
                        final = amount*0.97
                    }else if(after=="Peso"){
                        final = amount*19.52
                    }else{
                        final = amount
                    }
                }
            }
            val cuenta = final.toString()
            result.text = "The result is $cuenta"

        }
    }
}