package com.rrdsolutions.projectwardex.ui

import android.content.Context
import android.view.LayoutInflater
import android.view.LayoutInflater.*
import android.view.View
import android.view.ViewGroup
import android.widget.*
import com.rrdsolutions.projectwardex.R
import kotlinx.android.synthetic.main.fragment_secondary_selection.*

class ButtonGridAdapter
    (context: Context, private val resource: Int, private val itemList: Array<String>?)
    : ArrayAdapter<Int>(context, resource) {

    override fun getCount(): Int {
        return itemList?.size ?: 0
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {

        val button = Button(context).apply{
            text = itemList!![position]
            setOnClickListener{
                Toast.makeText(context, position.toString() + " clicked", Toast.LENGTH_LONG).show()
            }

        }

        return button
    }

    class ItemHolder {
        var button: Button? = null
    }

}

class ButtonGridAdapter2 (context: Context, private val resource: Int, private val itemList: Array<String>?)
    : ArrayAdapter<ButtonGridAdapter2.Holder>(context, resource) {

    override fun getCount(): Int {
        return if (this.itemList != null) this.itemList.size else 0
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        var cv = convertView
        val holder: Holder

        if (cv == null) {
            cv = from(context).inflate(resource, null)
            holder = Holder()
            holder.button = cv!!.findViewById(R.id.btn)
            cv.tag = holder
        }
        else {
            holder = cv.tag as Holder
        }

        holder.button!!.text = this.itemList!![position]
        return cv
    }

    class Holder {
        var button: Button?= null
    }
}
