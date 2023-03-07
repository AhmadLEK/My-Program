package com.example.myprogram.db

import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import androidx.core.content.contentValuesOf

class MyDbHelper(context: Context, factory: SQLiteDatabase.CursorFactory?) :
    SQLiteOpenHelper(context, DATABASE_NAME, factory, DATABASE_VERSION) {

    override fun onCreate(db: SQLiteDatabase) {

        val query = ("CREATE TABLE " + TABLE_NAME + " ("
                + ID_COL + " INTEGER PRIMARY KEY, " +
                FIRST_NAME_COL + " TEXT," +
                LAST_NAME_COl + " TEXT" + EMAIL_COL + ")")

        db.execSQL(query)
    }

    override fun onUpgrade(db: SQLiteDatabase, p1: Int, p2: Int) {

        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME)
        onCreate(db)
    }

    fun signIn(name : String, last : String, email: String ){

        val values = ContentValues()
        values.put(FIRST_NAME_COL, name)
        values.put(LAST_NAME_COl, last)
        values.put(EMAIL_COL, email)

        val db = this.writableDatabase
        db.insert(TABLE_NAME, null, values)
        db.close()
    }

    fun getName(): Cursor? {
        val db = this.readableDatabase
        return db.rawQuery("SELECT * FROM " + TABLE_NAME, null)
    }

    fun delete (row_id: String){
        val db = this.writableDatabase
        db.delete(TABLE_NAME, "$ID_COL = ?", arrayOf(row_id) )
        db.close()
    }

    companion object{

        const val DATABASE_NAME = "GEEKS_FOR_GEEKS"
        const val DATABASE_VERSION = 1
        const val TABLE_NAME = "users"

        const val ID_COL = "id"
        const val FIRST_NAME_COL = "name"
        const val LAST_NAME_COl = "last"
        const val EMAIL_COL = "email"
    }
}