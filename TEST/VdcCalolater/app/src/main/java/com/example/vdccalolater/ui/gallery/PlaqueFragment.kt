package com.example.vdccalolater.ui.gallery

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.vdccalolater.R

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


