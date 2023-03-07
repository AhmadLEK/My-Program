package com.example.myprogram

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.example.myprogram.databinding.ActivityProfileBinding
import com.example.myprogram.db.MyDbHelper

class ProfileActivity : AppCompatActivity() {
    private var dbHelper = MyDbHelper(this,null)
    lateinit var binding: ActivityProfileBinding
    lateinit var  modId : String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityProfileBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnLogOut.setOnClickListener {
            clickClose()

        }

    }

    fun clickBack (view: View){
        finish()
    }

    fun clickClose() {
        val i = Intent(this, MainActivity::class.java)
        startActivity(i)
    }

//    fun delete(){
//        dbHelper.delete(modId)
//        Toast.makeText(this, "Данные удалены", Toast.LENGTH_SHORT).show()
//    }
}