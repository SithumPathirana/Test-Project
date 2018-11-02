package com.example.sithum.testapplication

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import com.example.sithum.testapplication.R.id.parent


lateinit var recyclerView:RecyclerView

class DisplayRecyclerView : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_display_recycler_view)

        recyclerView =findViewById(R.id.recyclerView)
        recyclerView.layoutManager=LinearLayoutManager(this)
        recyclerView.adapter=MyAdapter(generateValues())
    }


    fun generateValues():List<String>{
        val data=ArrayList<String>()
        for (i in 1..100){
            data.add("Element $i")
        }
        return data
    }

}


class MyAdapter(private val myDataset: List<String>) :
    RecyclerView.Adapter<MyAdapter.MyViewHolder>(){

    class MyViewHolder( itemView: View) : RecyclerView.ViewHolder(itemView){
        var textView:TextView?=null
        init {
            textView=itemView?.findViewById(R.id.recycler_text)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val itemView = LayoutInflater.from(parent?.context).inflate(R.layout.list_item_layout,parent,false)
        return MyViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder?.textView?.text=myDataset[position]
    }

    override fun getItemCount(): Int {
       return myDataset.size
    }

}