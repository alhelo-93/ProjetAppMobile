package com.example.vdccalculatorv2.ui.Entretien

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.vdccalculatorv2.R

class EntretienFragment : Fragment() {

    private lateinit var entretienViewModel: EntretienViewModel

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        entretienViewModel =
                ViewModelProvider(this).get(EntretienViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_entretien, container, false)
        return root
    }
}