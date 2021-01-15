package com.example.vdccalolater.ui.Assurance

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.vdccalolater.R
import com.example.vdccalolater.ui.gallery.GalleryViewModel

class AssuranceFragment  : Fragment(){

    private lateinit var assuranceViewModel: AssuranceViewModel

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        assuranceViewModel =
                ViewModelProvider(this).get(AssuranceViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_assurance, container, false)

        return root
    }
}