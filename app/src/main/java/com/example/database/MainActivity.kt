package com.example.database

import android.content.Intent
import android.os.Bundle
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.textfield.TextInputEditText
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase

class MainActivity : AppCompatActivity() {


    private lateinit var database:DatabaseReference


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val name=findViewById<TextInputEditText>(R.id.Name)
        val password=findViewById<TextInputEditText>(R.id.Password)
        val email=findViewById<TextInputEditText>(R.id.Email)
        val signUp=findViewById<TextView>(R.id.sign)
        val id=findViewById<TextInputEditText>(R.id.Eid)



        signUp.setOnClickListener(){

            val tname=name.text.toString()
            val tpassword=password.text.toString()
            val tmail=email.text.toString()
            val tid=id.text.toString()

            val user=User(tname,tmail,tpassword,tid)
            database=FirebaseDatabase.getInstance().getReference("Users")
            database.child(tid).setValue(user).addOnSuccessListener {
                Toast.makeText(this,"User Registered",Toast.LENGTH_LONG).show()
            }.addOnFailureListener(){
                Toast.makeText(this,"Failed",Toast.LENGTH_LONG).show()
            }
        }

        val  signIn=findViewById<TextView>(R.id.signI)
        signIn.setOnClickListener(){
            val intent= Intent(this,SignIn::class.java)
            startActivity(intent)
        }
    }
}