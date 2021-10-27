package com.example.signin_signup

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.content.Intent
import android.content.SharedPreferences
import android.widget.EditText
import android.widget.TextView


class details : AppCompatActivity() {
    lateinit var btnSginout:Button
    lateinit var tvPhone:TextView
    lateinit var tvName:TextView
    lateinit var tvloc:TextView
    lateinit var spf: SharedPreferences
    lateinit var d: String
    lateinit var s: String
    lateinit var txt:TextView
    lateinit var txt2:TextView

    lateinit var dbhr: dbhelper

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.details)
        btnSginout=findViewById(R.id.btn_signout)
        txt=findViewById(R.id.txt1)
        txt2=findViewById(R.id.txt2)

        dbhr = dbhelper(applicationContext)

        spf =  getSharedPreferences("PREFERENCE_NAME", Context.MODE_PRIVATE)

        s = spf.getString("mob","default value").toString()

        txt.setText("Welcome "+s+"!"+"\n")

        d = dbhr.getdet(s)

        txt2.setText(d+"\n")



        btnSginout.setOnClickListener {
            val myIntent = Intent(this, MainActivity::class.java)

            this.startActivity(myIntent)
        }
    }
}