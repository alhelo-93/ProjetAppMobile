package com.example.vdccalculatorv2.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.vdccalculatorv2.R

class HomeFragment : Fragment() {

    private lateinit var homeViewModel: HomeViewModel

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        homeViewModel =
                ViewModelProvider(this).get(HomeViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_home, container, false)
        val textViewConso: TextView = root.findViewById(R.id.Conso_moy_TextView)
        homeViewModel.text.observe(viewLifecycleOwner, Observer {
            textViewConso.text = it
        })
        val textViewPuiss: TextView = root.findViewById(R.id.Puiss_KW_TextView)
        homeViewModel.text.observe(viewLifecycleOwner, Observer {
            textViewConso.text = it
        })
        val textViewCarbu: TextView = root.findViewById(R.id.Carbu_TextView)
        homeViewModel.text.observe(viewLifecycleOwner, Observer {
            textViewConso.text = it
        })
        val textViewPoidsT: TextView = root.findViewById(R.id.PoidsT_TextView)
        homeViewModel.text.observe(viewLifecycleOwner, Observer {
            textViewConso.text = it
        })
        val textViewCylind: TextView = root.findViewById(R.id.Cylind_TextView)
        homeViewModel.text.observe(viewLifecycleOwner, Observer {
            textViewConso.text = it
        })
        val textViewAnnee: TextView = root.findViewById(R.id.Annee_TextView)
        homeViewModel.text.observe(viewLifecycleOwner, Observer {
            textViewConso.text = it
        })

        return root
    }
}