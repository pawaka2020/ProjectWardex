package com.rrdsolutions.projectwardex.ui.selection

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.Toolbar
import androidx.fragment.app.viewModels
import com.rrdsolutions.projectwardex.R
import com.rrdsolutions.projectwardex.ui.ButtonGridAdapter2
import com.rrdsolutions.projectwardex.ui.CardGridAdapter
import kotlinx.android.synthetic.main.fragment_selection.*

class SelectionFragment : Fragment() {
    val vm:SelectionViewModel by viewModels()

    //prevents crashes when screen rotates during Retrofit calls
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        retainInstance = true
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_selection, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val st: String = arguments?.getString("Selectiontype")!!
        activity?.findViewById<Toolbar>(R.id.toolbar)?.title = st
        init(st)
    }

    fun init(st:String){
        vm.categoryFetch(st){it->
            val list = it
            if (it.isNotEmpty())
            grid.adapter = ButtonGridAdapter2(this.requireContext(), R.layout.button, list)
            //grid.adapter = ButtonGridAdapter2(this.requireContext(), R.layout.button, it)
        }
    }

}

class SelectionType{
    val primary = "Primary"
    val secondary = "Secondary"
    val melee = "Melee"
    val archwing = "Archwing"
}

