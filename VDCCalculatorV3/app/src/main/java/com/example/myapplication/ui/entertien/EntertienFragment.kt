package com.example.myapplication.ui.entertien

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.myapplication.R

class EntertienFragment : Fragment() {

    private lateinit var entertienViewModel: EntertienViewModel

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        entertienViewModel =
                ViewModelProvider(this).get(EntertienViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_entertien, container, false)

        return root
    }
}