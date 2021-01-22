package com.example.myapplication.ui.coutst

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.myapplication.R
import com.example.myapplication.ui.entertien.EntertienViewModel

class CoutstFragment : Fragment() {

    private lateinit var coutstViewModel: CoutstViewModel

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        coutstViewModel =
                ViewModelProvider(this).get(CoutstViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_totalcosts, container, false)

        return root
    }
}