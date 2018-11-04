package com.example.sithum.testapplication

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.text.LoginFilter
import android.view.View
import android.widget.Button
import android.widget.EditText

class Login : AppCompatActivity() {

    lateinit var username:EditText
    lateinit var password:EditText
    lateinit var signInButton:Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        username=findViewById(R.id.login_username)
        password=findViewById(R.id.login_password)
        signInButton=findViewById(R.id.signin_button)
    }

    fun onLoginClick(view:View){
        val intent=Intent(this,MainActivity::class.java)
        startActivity(intent)
    }
}
