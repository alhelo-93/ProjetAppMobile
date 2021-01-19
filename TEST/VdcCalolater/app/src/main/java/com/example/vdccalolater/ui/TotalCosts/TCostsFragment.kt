package com.example.vdccalolater.ui.TotalCosts

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.vdccalolater.R

class TCostsFragment : Fragment() {

    private lateinit var tcostsViewModel: TCostsViewModel

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        tcostsViewModel =
                ViewModelProvider(this).get(TCostsViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_totalcosts, container, false)
        return root
    }
}