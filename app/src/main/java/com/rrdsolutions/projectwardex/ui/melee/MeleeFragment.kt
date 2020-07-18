package com.rrdsolutions.projectwardex.ui.melee

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.rrdsolutions.projectwardex.R

class MeleeFragment : Fragment() {

    companion object {
        fun newInstance() = MeleeFragment()
    }

    private lateinit var viewModel: MeleeViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.melee_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(MeleeViewModel::class.java)
        // TODO: Use the ViewModel
    }

}