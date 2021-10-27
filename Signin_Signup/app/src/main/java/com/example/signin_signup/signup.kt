package com.example.signin_signup

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.content.Intent
import android.content.SharedPreferences
import android.widget.EditText
import android.widget.Toast


class signup : AppCompatActivity() {
    lateinit var btnSginup:Button
    lateinit var edPhone:EditText
    lateinit var edPassword:EditText
    lateinit var edName:EditText
    lateinit var edloc:EditText
    lateinit var dbhr: dbhelper
    lateinit var spf: SharedPreferences
    lateinit var editr: SharedPreferences.Editor

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sginup)
        btnSginup=findViewById(R.id.btn_signup1)
        edPhone=findViewById(R.id.ed_phone)
        edPassword=findViewById(R.id.ed_password)
        edName=findViewById(R.id.ed_name)
        edloc=findViewById(R.id.ed_loc)
        dbhr = dbhelper(applicationContext)
        spf =  getSharedPreferences("PREFERENCE_NAME", Context.MODE_PRIVATE)
        editr = spf.edit()


        btnSginup.setOnClickListener {
            var s1 = edName.text.toString()
            var s2 = edloc.text.toString()
            var s3 = edPhone.text.toString()
            var s4 = edPassword.text.toString()

            var k = dbhr.savedet(s1, s2, s3, s4)

            Toast.makeText(applicationContext, "data saved successfully! ", Toast.LENGTH_SHORT)
                .show();
            if (k.equals("-1")) {
                Toast.makeText(applicationContext, "Error data not saved!", Toast.LENGTH_SHORT)
                    .show();
            } else {
                editr.putString("mob",s3).commit()
                Toast.makeText(applicationContext, "save success!", Toast.LENGTH_SHORT).show();
                Intent(this, details::class.java).apply {
                    startActivity(this)
                }
            }        }
    }
}