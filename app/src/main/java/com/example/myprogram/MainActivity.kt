package com.example.myprogram

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import android.widget.Toast
import com.example.myprogram.databinding.ActivityMainBinding
import com.example.myprogram.db.MyDbHelper

class MainActivity : AppCompatActivity() {
    private val dbHelper = MyDbHelper(this, null)
    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnSignIn.setOnClickListener {

            val firstname = binding.firstName.text
            val lastname = binding.lastName.text
            val emailname = binding.emailName.text

            val first = "Umar"
            val last = "Umarov"
            val email = "umarov@mail.ru"

            if (firstname.isNullOrEmpty() || lastname.isNullOrEmpty() || emailname.isNullOrEmpty()){
                Toast.makeText(this, " Введите данные", Toast.LENGTH_LONG).show()
            }
            else if (firstname.toString() == first || lastname.toString() == last || emailname.toString() == email){
                Toast.makeText(this, "Данный профиль существует", Toast.LENGTH_SHORT).show()
            }
            else {
                clickSignIn()
            }

        }

        val em = binding.emailName
        em.addTextChangedListener(object: TextWatcher {
            override fun afterTextChanged(s: Editable?) {}
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}
            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                    if (android.util.Patterns.EMAIL_ADDRESS.matcher(em.text.toString()).matches())
                        binding.btnSignIn.isEnabled = true
                    else {
                            binding.btnSignIn.isEnabled = false
                            binding.emailName.setError("Email недействительный")
                    }
            }
        })

    }

    fun clickLogIn(view: View){
        val i = Intent(this, LoginActivity::class.java)
        startActivity(i)
    }

    fun clickSignIn() {
        val name = binding.firstName.text.toString()
        val last = binding.lastName.text.toString()
        val email = binding.emailName.text.toString()
        dbHelper.signIn(name, last, email)
        Toast.makeText(this, "Данные добавленны", Toast.LENGTH_SHORT).show()
        val x = Intent(this, PageActivity1::class.java)
        startActivity(x)
    }

//    fun prof (){
//        val firstname = binding.firstName.text
//        val lastname = binding.lastName.text
//        val emailname = binding.emailName.text
//
//        val first = "Ahmad"
//        val last = "Amirov"
//        val email = "amirov@mail.ru"
//
//        if (firstname.toString() == first || lastname.toString() == last || emailname.toString() == email){
//            Toast.makeText(this, "Данные профиль существует", Toast.LENGTH_SHORT).show()
//        }
//    }

}

