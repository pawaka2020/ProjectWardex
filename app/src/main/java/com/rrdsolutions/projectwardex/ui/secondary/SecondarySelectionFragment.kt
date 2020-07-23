package com.rrdsolutions.projectwardex.ui.secondary

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.rrdsolutions.projectwardex.R
import com.rrdsolutions.projectwardex.ui.ButtonGridAdapter2
import kotlinx.android.synthetic.main.fragment_secondary_selection.*

class SecondarySelectionFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_secondary_selection, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val buttonlist = arrayOf("Single", "Dual", "Throwing" )
        //grid.adapter = ButtonGridAdapter(this.requireContext(), 0, buttonlist )
        //grid.adapter = ButtonGridAdapter2(this.requireContext(), R.layout.button, buttonlist)
    }

}