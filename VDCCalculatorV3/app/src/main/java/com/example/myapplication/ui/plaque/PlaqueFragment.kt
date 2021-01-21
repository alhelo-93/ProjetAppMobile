package com.example.myapplication.ui.plaque

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.myapplication.R

class PlaqueFragment : Fragment() {

    private lateinit var plaqueViewModel: PlaqueViewModel

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        plaqueViewModel =
                ViewModelProvider(this).get(PlaqueViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_plaque, container, false)

        return root
    }
}