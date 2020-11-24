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

        // get refence to button and edittext

        var btn_calculate = findViewById(R.id.button2) as Button

        btn_calculate.setOnClickListener(View.OnClickListener {
            var PdNumber = findViewById(R.id.editTextNumber) as EditText
            var ChNumber = findViewById(R.id.editTextNumber2) as EditText
            var PlNumber = findViewById(R.id.editTextNumber3) as EditText
            var ChfView = findViewById<View>(R.id.textView4) as TextView

            // String to int conversion
            val pdNumberstr: String = PdNumber.text.toString()
            val pdNumberInt = pdNumberstr.toInt()
            val chNumberstr: String = ChNumber.text.toString()
            var chNumberInt = chNumberstr.toInt()
            val plNumbersrt: String = PlNumber.text.toString()
            var plNumberInt = plNumbersrt.toInt()
            var num2 = 0
            var chNumberTot = 0
            // les constants
            // the price by KG
            var KgPrice : Double = 0.15
            // Unite KW
            var KW : Int = 100
            // if less than 100KW
            var KW100OrLess :Int = 2  // CHF
            // if more than 100KW
            var KWMore100 : Int = 3 // CHF



            var pdNumberTot = pdNumberInt * KgPrice
            //If we have 100 kW or less
            if (chNumberInt <= KW) {
                 chNumberTot = chNumberInt * KW100OrLess
            }
            //If we have more than 100 KW
            else {
                // we substract 100 from the total kw
                var chMore100 = chNumberInt - KW
                //the rest we multiply by 3
                var chMore100Cl = chMore100 * KWMore100
                //the 100 we multiply by 2
                var ch100 = KW * 2
                //We add all together
                 chNumberTot = chMore100Cl + ch100
            }
            //If the car polutes less than 125G of Co2/Km or electric/hybrid car
            if (plNumberInt < 125) {
                //we take the total power in KW  price and we add the total weigth price
                var restot = chNumberTot + pdNumberTot
                //We make the 75% of the total price if the car is "Green"
                var restotrab = restot - restot * 75 / 100
                //we add the base taxe to all vehicles
                var restotrabfin : Double = restotrab + 40
                //show the total result price
                ChfView.text = "La taxe de palques sera de " + restotrabfin
            }
            //If we polute more than than 125G of Co2/Km
            else {
                //we take the total power in KW  price and we add the total weigth price
                var restot = chNumberTot + pdNumberTot
                //we add the base taxe to all vehicles
                var restrotfin = restot + 40
                //show the total result price
                ChfView.text = "La taxe de palques sera de " + restrotfin
            }

        })


    }
}



