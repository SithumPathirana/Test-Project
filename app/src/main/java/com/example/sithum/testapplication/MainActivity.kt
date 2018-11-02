package com.example.sithum.testapplication

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText

const val EXTRA_MESSAGE = "com.example.myfirstapp.MESSAGE"

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun sendMessage(view:View){
        val editText = findViewById<EditText>(R.id.editText)
        val message = editText.text.toString()
        val intent = Intent(this, DisplayMessageActivity::class.java).apply {
            putExtra(EXTRA_MESSAGE, message)
        }
        startActivity(intent)
    }

    fun goToListView(view:View){
        val intent=Intent(this,DisplayListView::class.java)
        startActivity(intent)
    }

    fun goToRecyclerView(view: View){
        val intent=Intent(this,DisplayRecyclerView::class.java)
        startActivity(intent)
    }

    fun goToFragments(view: View){
        val intent=Intent(this,DisplayFragments::class.java)
        startActivity(intent)
    }

}

