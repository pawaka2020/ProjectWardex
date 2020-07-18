package com.rrdsolutions.projectwardex.ui.archwing

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.rrdsolutions.projectwardex.R

class ArchwingFragment : Fragment() {

    companion object {
        fun newInstance() = ArchwingFragment()
    }

    private lateinit var viewModel: ArchwingViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.archwing_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(ArchwingViewModel::class.java)
        // TODO: Use the ViewModel
    }

}