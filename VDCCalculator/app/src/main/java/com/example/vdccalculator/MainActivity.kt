package com.example.vdccalculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.PersistableBundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // get refence to button
        var btn_calculate = findViewById<View>(R.id.button2) as Button
        var PdNumber = findViewById<View>(R.id.editTextNumber) as EditText
        var ChNumber = findViewById<View>(R.id.editTextNumber2) as EditText
        var PlNumber = findViewById<View>(R.id.editTextNumber3) as EditText
        var ChfView = findViewById<View>(R.id.textView4) as TextView

        btn_calculate.setOnClickListener(View.OnClickListener {
            var num1 = PdNumber * 0.15
            var num2 = 0
            if (ChNumber >200){
                 num2 = ChNumber  * 3
            }else {
                 num2 = ChNumber * 2
            }

            var restot = num1 + num2
            if (PlNumber < 125){

            }
            ChfView.text="La taxe de palques sera de"+(restot.text.ToString())
        })


    }
}