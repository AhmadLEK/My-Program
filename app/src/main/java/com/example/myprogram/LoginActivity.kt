package com.example.myprogram

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import android.widget.Toast
import com.example.myprogram.databinding.ActivityLoginBinding
import com.example.myprogram.db.MyDbHelper

class LoginActivity : AppCompatActivity() {
    lateinit var binding: ActivityLoginBinding
    private val db = MyDbHelper(this, null)

    @SuppressLint("Range")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnLogin.setOnClickListener {

            val firstname = binding.firstName2.text
            val password = binding.password.text
            val name = "Umar"
            val pas = "12345678"

            if (firstname.isNullOrEmpty() || password.isNullOrEmpty()){
                Toast.makeText(this, " Введите данные", Toast.LENGTH_LONG).show()
            }
            else if (firstname.toString() != name || password.toString() != pas){
                Toast.makeText(this, " Создайте профиль", Toast.LENGTH_LONG).show()
            }
            else if (firstname.toString() == name || password.toString() == pas){
                clickPage()
                Toast.makeText(this, " Ваш профиль", Toast.LENGTH_LONG).show()
            }

        }

    }

    fun clickPage() {
        val i = Intent(this, PageActivity1::class.java)
        startActivity(i)
    }

}

