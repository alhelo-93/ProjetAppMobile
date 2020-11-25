package com.example.vdccalculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.PersistableBundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.google.android.material.bottomnavigation.BottomNavigationView
import java.math.BigInteger
import kotlin.math.absoluteValue


class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setupNavigation()
        // get refence to button and edittext

        var btn_calculate = findViewById(R.id.button2) as Button

        btn_calculate.setOnClickListener(View.OnClickListener
        {
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
            // Here constant
            // The Kg price of cars wight
            var Kgprice: Double = 0.15
            // The engine power  Measured on  KW
            var KwMeasure: Int = 100
            // The price if less than KwMeasure
            var lowerPrice: Int = 2
            // The price if less than KwMeasure
            var higherPrice: Int = 3
            // The pollution Measured By Co2/KM
            var CO2Measure: Int = 125
            // the base taxes to all vehicles
            var BasicTaxes: Int = 40
            // Green Taxes
            var GreenRebate: Double = 0.75


            var pdNumberTot = pdNumberInt * Kgprice
            //If we have 100 kW or less
            if (chNumberInt <= KwMeasure) {
                chNumberTot = chNumberInt * lowerPrice
            }
            //If we have more than 100 KW
            else {
                // we substract 100 from the total kw
                var chMore100 = chNumberInt - KwMeasure
                //the rest we multiply by 3
                var chMore100Cl = chMore100 * higherPrice
                //the 100 we multiply by 2
                var ch100 = KwMeasure * lowerPrice
                //We add all together
                chNumberTot = chMore100Cl + ch100
            }
            //If the car pollutes less than 125G of Co2/Km or electric/hybrid car
            if (plNumberInt < CO2Measure) {
                //we take the total power in KW  price and we add the total weigth price
                var restot = chNumberTot + pdNumberTot
                //We make the 75% of the total price if the car is "Green"
                var restotrab = restot - (restot * GreenRebate)
                //we add the base taxe to all vehicles
                var restotrabfin = restotrab + BasicTaxes
                //show the total result price
                ChfView.text = "La taxe de palques sera de " + restotrabfin
            }
            //If we polute more than than 125G of Co2/Km
            else {
                //we take the total power in KW  price and we add the total weigth price
                var restot = chNumberTot + pdNumberTot
                //we add the base taxe to all vehicles
                var restrotfin = restot + BasicTaxes
                //show the total result price
                ChfView.text = "La taxe de palques sera de " + restrotfin
            }


        })


    }

    private fun setupNavigation() {
        val navView: BottomNavigationView = findViewById(R.id.nav_view)
        navView.setOnNavigationItemSelectedListener { item ->
            when (item.itemId) {
                R.id.home -> {
                    Toast.makeText(this, "Taxe Plaques", Toast.LENGTH_SHORT).show()
                    true
                }
                R.id.Photos -> {
                    Toast.makeText(this, "Coût entretien", Toast.LENGTH_SHORT).show()
                    true
                }
                R.id.more -> {
                    Toast.makeText(this, "Tableau de coûts", Toast.LENGTH_SHORT).show()
                    true
                }
                else -> true
            }
        }
    }


}



