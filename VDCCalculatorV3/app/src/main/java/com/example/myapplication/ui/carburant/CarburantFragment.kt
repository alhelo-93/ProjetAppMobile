package com.example.myapplication.ui.carburant

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.myapplication.R
import com.example.myapplication.ui.entertien.EntertienViewModel

class CarburantFragment : Fragment() {

    private lateinit var carburantViewModel: CarburantViewModel

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        carburantViewModel =
                ViewModelProvider(this).get(CarburantViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_carburant, container, false)

        return root
    }
}