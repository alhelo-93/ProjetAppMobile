package com.example.vdccalolater

import android.os.Bundle
import android.view.Menu
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.snackbar.Snackbar
import com.google.android.material.navigation.NavigationView
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import androidx.drawerlayout.widget.DrawerLayout
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar

class MainActivity : AppCompatActivity() {

    private lateinit var appBarConfiguration: AppBarConfiguration

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val toolbar: Toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)


        val drawerLayout: DrawerLayout = findViewById(R.id.drawer_layout)
        val navView: NavigationView = findViewById(R.id.nav_view)
        val navController = findNavController(R.id.nav_host_fragment)
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        appBarConfiguration = AppBarConfiguration(setOf(
                R.id.nav_home, R.id.nav_gallery, R.id.nav_slideshow,R.id.nav_assurance), drawerLayout)
        setupActionBarWithNavController(navController, appBarConfiguration)
        navView.setupWithNavController(navController)
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.main, menu)
        return true
    }

    override fun onSupportNavigateUp(): Boolean {
        val navController = findNavController(R.id.nav_host_fragment)
        return navController.navigateUp(appBarConfiguration) || super.onSupportNavigateUp()
    }
}

class PlaquesActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.fragment_plaque)

        // get refence to button and edittext

        var btn_calculate = findViewById(R.id.button2) as Button

        btn_calculate.setOnClickListener(View.OnClickListener
        {
            var PdNumber = findViewById(R.id.totalWeight) as EditText
            var ChNumber = findViewById(R.id.PowerWatt) as EditText
            var PlNumber = findViewById(R.id.carbonO2) as EditText

            var ChfView = findViewById<View>(R.id.result) as TextView

            // String to int conversion
            val pdNumberstr: String = PdNumber.text.toString()
            val pdNumberInt = pdNumberstr.toInt()
            val chNumberstr: String = ChNumber.text.toString()
            var chNumberInt = chNumberstr.toInt()
            val plNumbersrt: String = PlNumber.text.toString()
            var plNumberInt = plNumbersrt.toInt()
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
            var CO2Measure: Int = 120
            // the base taxes to all vehicles
            var BasicTaxes: Int = 40
            // Green Taxes
            var GreenRebate: Double = 0.75


            // if (PdNumber.isEmpty(text)){
            //      totalWeight.setError("faut introduir un numéro ");
            //    }else {
            //do something
            //  }

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
            if (plNumberInt <= CO2Measure) {
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

}