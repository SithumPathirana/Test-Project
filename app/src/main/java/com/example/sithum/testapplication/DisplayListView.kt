package com.example.sithum.testapplication

import android.content.Context
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_display_list_view.*

class DisplayListView : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_display_list_view)

        val list:ListView=findViewById(R.id.listView) as ListView
        list.adapter=CustomAdapater(this,generateValues())
    }

    fun generateValues():List<String>{
        val data=ArrayList<String>()
        for(i in 1..100){
           data.add("$i element")

        }
        return  data
    }
}

class CustomAdapater(context:Context,private var values : List<String>)
    :ArrayAdapter<String>(context,R.layout.activity_display_list_view,values) {

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val rowView=LayoutInflater.from(context).inflate(R.layout.row_layout,parent,false)
        val textView:TextView=rowView.findViewById(R.id.text_list_element)
        textView.text=values[position]
        return rowView
    }
}
