package com.example.vdccalculatorv2.ui.couts

import com.example.vdccalculatorv2.ui.Entretien.EntretienViewModel
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.vdccalculatorv2.R

class CoutsFragment : Fragment() {


    private lateinit var coutsViewModel: EntretienViewModel

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        coutsViewModel =
                ViewModelProvider(this).get(EntretienViewModel::class.java)
        val root = inflater.inflate(R.layout.freagment_couts_totaux, container, false)
        return root
    }
}