package com.rrdsolutions.projectwardex.ui.primary

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.rrdsolutions.projectwardex.R

class PrimaryFragment : Fragment() {

    companion object {
        fun newInstance() = PrimaryFragment()
    }

    private lateinit var viewModel: PrimaryViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.primary_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(PrimaryViewModel::class.java)
        // TODO: Use the ViewModel
    }

}