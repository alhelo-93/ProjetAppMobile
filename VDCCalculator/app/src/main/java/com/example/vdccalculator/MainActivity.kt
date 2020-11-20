package com.example.vdccalculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.PersistableBundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import java.math.BigInteger
import kotlin.math.absoluteValue


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // get refence to button

        var btn_calculate = findViewById(R.id.button2) as Button

        btn_calculate.setOnClickListener(View.OnClickListener {
            var PdNumber = findViewById(R.id.editTextNumber) as EditText
            var ChNumber = findViewById(R.id.editTextNumber2) as EditText
            var PlNumber = findViewById(R.id.editTextNumber3) as EditText
            var ChfView = findViewById<View>(R.id.textView4) as TextView

            val pdNumberstr:String = PdNumber.text.toString()
            val pdNumberInt = pdNumberstr.toInt()
            val chNumberstr:String = ChNumber.text.toString()
            var chNumberInt = chNumberstr.toInt()
            val plNumbersrt:String = PlNumber.text.toString()
            var plNumberInt = plNumbersrt.toInt()
            var num2 = 0

            var pdNumberTot= pdNumberInt * 0.15
            var chNumberTot = chNumberInt*2


           var restot = chNumberTot + pdNumberTot + 40
            ChfView.text="La taxe de palques sera de"+restot
        })


    }
}



