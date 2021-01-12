package com.example.vdccalculatorv2.ui.Plaques

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.vdccalculatorv2.R

class PlaquesFragment : Fragment() {

    private lateinit var plaquesViewModel: PlaquesViewModel

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        plaquesViewModel =
                ViewModelProvider(this).get(PlaquesViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_plaques, container, false)
        val textView: TextView = root.findViewById(R.id.nav_plaques)
        plaquesViewModel.text.observe(viewLifecycleOwner, Observer {
            textView.text = it
        })
        return root
    }
}