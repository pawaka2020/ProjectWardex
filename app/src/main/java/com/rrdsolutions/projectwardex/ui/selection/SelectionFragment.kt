package com.rrdsolutions.projectwardex.ui.selection

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
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
        lateinit var list:List<String>
        val context = this.requireContext()
//        MainScope().launch{
//            withContext(Dispatchers.Default){
//                RetrofitRepo("https://api.warframestat.us/weapons/", "Primary")
//                    .categoryFetch2(){
//                        list = it
//                    }
//            }
//            grid.adapter = ButtonGridAdapter2(context, R.layout.button, list)
//        }
        init(st)



    }

    fun init0(st:String){
        lateinit var list:Array<String>
        when (st){
            (SelectionType().primary)-> list = SelectionCategories().primary
            (SelectionType().secondary)-> list = SelectionCategories().secondary
            (SelectionType().melee)-> list = SelectionCategories().melee
            (SelectionType().archwing)-> list = SelectionCategories().archwing
        }
        grid.adapter = CardGridAdapter(this.requireContext(), R.layout.selectioncard, list)
    }
    fun init(st:String){
        vm.categoryFetch(st){it->
            val list = it
            if (it.isNotEmpty())
            grid.adapter = ButtonGridAdapter2(this.requireContext(), R.layout.button, list)
        }


    }

}

class SelectionCategories{
    val primary = arrayOf("Rifle", "Shotgun", "Crossbow", "Pistol", "Bow", "Glaive", "Speargun","Sniper Rifle", "Launcher", "Arm-Cannon")
    val secondary = arrayOf("Pistol", "Dual Pistols", "Dual Shotguns", "Crossbow", "Shotgun Sidearm", "Thrown")
    val melee = arrayOf("Sword And Shield", "Staff", "Scythe", "Fist", "Hammer", "Whip",
        "Tonfa", "Sword", "Polearm", "Dagger", "Glaive", "Blade And Whip", "Melee", "Rapier", "Dual Swords",
        "Nikana", "Dual Daggers", "Heavy Blade", "Machete", "Warfan", "Sparring", "Nunchaku",
       "Two-Handed Nikana", "Gunblade", "Claws")
    val archwing = arrayOf("Arch-Gun", "Arch-Melee")
}
class SelectionType{
    val primary = "Primary"
    val secondary = "Secondary"
    val melee = "Melee"
    val archwing = "Archwing"
}

