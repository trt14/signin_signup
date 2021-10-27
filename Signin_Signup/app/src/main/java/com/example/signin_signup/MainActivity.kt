package com.example.signin_signup

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.content.Intent




class MainActivity : AppCompatActivity() {
    lateinit var btnSginin:Button
    lateinit var btnSginup:Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        btnSginin=findViewById(R.id.btn_Signin)
        btnSginup=findViewById(R.id.btn_Signup)

        btnSginin.setOnClickListener {
            val myIntent = Intent(this, signin::class.java)

            this.startActivity(myIntent)
        }
        btnSginup.setOnClickListener {
            val myIntent = Intent(this, signup::class.java)

            this.startActivity(myIntent)
        }
    }
}