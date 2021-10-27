package com.example.signin_signup

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.content.Intent
import android.content.SharedPreferences
import android.widget.EditText
import android.widget.Toast


class signin : AppCompatActivity() {
    lateinit var btnSginin:Button
    lateinit var edPhone:EditText
    lateinit var edPassword:EditText
    lateinit var dbhr: dbhelper
    lateinit var pw: String
    lateinit var spf: SharedPreferences
    lateinit var editr: SharedPreferences.Editor

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sginin)
        btnSginin=findViewById(R.id.btn_signin1)
        edPhone=findViewById(R.id.edin_phone)
        edPassword=findViewById(R.id.edin_password)
        dbhr = dbhelper(applicationContext)
        spf =  getSharedPreferences("PREFERENCE_NAME", Context.MODE_PRIVATE)
        editr = spf.edit()


        btnSginin.setOnClickListener {
            var s1=edPhone.text.toString()
            var s2=edPassword.text.toString()
            pw = dbhr.checkpassword(s1)
            if (pw.equals(s2)){
                editr.putString("mob",s1).commit()

                Toast.makeText(applicationContext, "Sign in success!", Toast.LENGTH_SHORT).show();


                Intent(this, details::class.java).apply {
                    startActivity(this)
                }

            } else{
                Toast.makeText(applicationContext, "Invaild details", Toast.LENGTH_SHORT).show();
            }        }
    }
}