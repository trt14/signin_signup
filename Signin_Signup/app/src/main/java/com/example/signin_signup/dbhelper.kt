package com.example.signin_signup

import android.annotation.SuppressLint
import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteException
import android.database.sqlite.SQLiteOpenHelper

class dbhelper(context: Context): SQLiteOpenHelper(
    context,
    DATABASE_NAME,
    null,
    DATABASE_VERSION){

    companion object{
        private const val DATABASE_VERSION = 1
        private const val DATABASE_NAME = "myapp.db"
        private const val TABLE_Name = "tbl_user"

        private const val KEY_ID = "_id"
        private const val KEY_Name = "Name"
        private const val KEY_Phone = "Phone"
        private const val KEY_Location = "Location"
        private const val KEY_Password = "password"

    }

    override fun onCreate(db: SQLiteDatabase?) {
        val createTable = ("CREATE TABLE $TABLE_Name($KEY_ID INTEGER PRIMARY KEY, $KEY_Name TEXT,$KEY_Phone TEXT,$KEY_Location TEXT,$KEY_Password TEXT)")
        db?.execSQL(createTable)
    }

    override fun onUpgrade(db: SQLiteDatabase?, p1: Int, p2: Int) {
        db!!.execSQL("DROP TABLE IF EXISTS $TABLE_Name")
        onCreate(db)
    }
    fun savedet(name: String, location: String, phone: String, password: String): Long {

        val db = this.writableDatabase

        val cv = ContentValues()
        cv.put("Name", name)
        cv.put("Location", location)
        cv.put("Phone", phone)
        cv.put("password", password)
        return db.insert( TABLE_Name, null, cv)

    }
    @SuppressLint("Range")
    fun checkpassword(mobile: String): String {
        //  sqLiteDatabase=writableDatabase
        val db = this.writableDatabase

        var c: Cursor = db.query(
            TABLE_Name, null, "Phone=?", arrayOf(mobile), null, null, null
        )
        if (c.count < 1) {
            return "name not exists"
        }
        c.moveToFirst()
        var loc = c.getString(c.getColumnIndex("password"))
        return loc
    }
    @SuppressLint("Range")
    fun getdet(mobile: String?): String {
        val db = this.writableDatabase

        var c: Cursor = db.query(
            TABLE_Name, null, "Phone=?", arrayOf(mobile), null, null, null
        )
        if (c.count < 1) {
            return "name not exists"
        }
        c.moveToFirst()
        var loc = c.getString(c.getColumnIndex("Name"))+"\n"+ c.getString(c.getColumnIndex("Location"))
        return loc
    }

}
