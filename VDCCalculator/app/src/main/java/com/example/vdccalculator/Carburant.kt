package com.example.vdccalculator



import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import com.developers.hand.second.navigationdrawerexercise.R


class Carburant : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.carburant_layout)

        // get refence to button and edittext

        var btn_calculate = findViewById(R.id.button) as Button

        btn_calculate.setOnClickListener(View.OnClickListener
        {
            var MoyenneNumber = findViewById(R.id.editTextNumberDecimal) as EditText
            var CNumber = findViewById(R.id.editTextNumberDecimal3) as EditText
            var PrixCNumber = findViewById(R.id.editTextNumberDecimal2) as EditText
            var NbPleins = findViewById(R.id.editTextNumberDecimal4) as EditText
            var ChfView = findViewById<View>(R.id.result) as TextView

            // String to int conversion
            val MoyenneNumberstr: String = MoyenneNumber.text.toString()
            val MoyenneNumberInt = MoyenneNumberstr.toDouble()
            val CNumberstr: String = CNumber.text.toString()
            var CNumberInt = CNumberstr.toInt()
            val PrixCNumbersrt: String = PrixCNumber.text.toString()
            var PrixCNumberInt = PrixCNumbersrt.toDouble()
            val NbPleinsstr: String = NbPleins.text.toString()
            var NbPleinsInt = CNumberstr.toInt()


            var prixtot = (PrixCNumberInt * CNumberInt)*NbPleinsInt
            ChfView.text = "Le Prix du carburant de ce mois a été " + prixtot




        })


    }






}



