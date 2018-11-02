package com.example.sithum.testapplication


import android.content.Context
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.PersistableBundle
import android.widget.TextView



var message: String? = null
lateinit var textView: TextView
private lateinit var displayMessageListner: DisplayMessageListner


internal class DisplayMessageListner(
    private val context: Context
){
        fun start(){
           println("Display Message = "+ message)
        }

        fun stop(){
            println("Display Message Activity Stopped")
        }

}

class DisplayMessageActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_display_message)

        displayMessageListner=DisplayMessageListner(this)

        message = intent.getStringExtra(EXTRA_MESSAGE)

        textView = findViewById<TextView>(R.id.textView).apply {
            text = message
        }


    }

    override fun onStart() {
        super.onStart()
        displayMessageListner.start()
    }

    override fun onStop() {
        super.onStop()
        displayMessageListner.stop()
    }

    override fun onSaveInstanceState(outState: Bundle?, outPersistentState: PersistableBundle?) {
        outState?.run {
            putString("text_view_val", textView.text.toString())
        }
        super.onSaveInstanceState(outState)
    }
}
