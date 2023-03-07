package com.example.myprogram

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.example.myprogram.databinding.ActivityPage1Binding
import com.example.myprogram.db.MyDbHelper

class PageActivity1 : AppCompatActivity() {
    private var dbHelper = MyDbHelper(this,null)
    lateinit var binding: ActivityPage1Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPage1Binding.inflate(layoutInflater)
        setContentView(binding.root)

    }

    fun clickProfile(view: View){
        val c = Intent (this, ProfileActivity::class.java)
        startActivity(c)
    }

}