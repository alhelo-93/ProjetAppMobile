package com.example.vdccalculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.PersistableBundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // get refence to button
        val btn_alculate = findViewById(R.id.button2) as Button
        val PdNumber = findViewById(R.id.editTextNumber) as EditText
        val ChNumber = findViewById(R.id.editTextNumber2) as EditText
        val PlNumber = findViewById(R.id.editTextNumber3) as EditText
        val ChfView = findViewById(R.id.textView4) as TextView




        fun inputIsNotEmpty():Boolean{
            var b = true
            if (PdNumber.text.toString().trim().isEmpty()){
                PdNumber.error = "Requierd"
            }
            if (ChNumber.text.toString().trim().isEmpty()){
                ChNumber.error = "Requierd"
            }
            if (PlNumber.text.toString().trim().isEmpty()){
                PlNumber.error = "Requierd"
            }
            return b
        }

        fun CalculateTax(){
            if (inputIsNotEmpty()){
                val input1 = PdNumber.text.toString().trim().toBigInteger()
                val input2 = ChNumber.text.toString().trim().toBigInteger()
                val input3 = PlNumber.text.toString().trim().toBigInteger()
            }
        }

        btn_alculate.setOnClickListener(){
            CalculateTax()
        }

    }
}