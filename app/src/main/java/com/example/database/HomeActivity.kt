package com.example.database

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class HomeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        val email=intent.getStringExtra(SignIn.Key1)
        val name=intent.getStringExtra(SignIn.Key2)
        val userId=intent.getStringExtra(SignIn.Key3)
        val password=intent.getStringExtra(SignIn.Key4)

        val tname=findViewById<TextView>(R.id.name)
        val temail=findViewById<TextView>(R.id.email)

        tname.text=name
        temail.text=email




    }
}