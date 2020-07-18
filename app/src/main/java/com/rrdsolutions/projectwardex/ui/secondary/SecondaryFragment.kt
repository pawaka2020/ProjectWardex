package com.rrdsolutions.projectwardex.ui.secondary

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.rrdsolutions.projectwardex.R

class SecondaryFragment : Fragment() {

    companion object {
        fun newInstance() = SecondaryFragment()
    }

    private lateinit var viewModel: SecondaryViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.secondary_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(SecondaryViewModel::class.java)
        // TODO: Use the ViewModel
    }

}