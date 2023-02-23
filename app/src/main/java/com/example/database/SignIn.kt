package com.example.database

import android.content.Intent
import android.os.Bundle
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.textfield.TextInputEditText
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase

class SignIn : AppCompatActivity() {

    private lateinit var dataBase:DatabaseReference
    companion object{
        const val Key1="package com.example.database.MainActivity.Key1.email"
        const val Key2="package com.example.database.MainActivity.Key2.name"
        const val Key3="package com.example.database.MainActivity.Key3.userId"
        const val Key4="package com.example.database.MainActivity.Key4.password"

    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_in)


        val name=findViewById<TextInputEditText>(R.id.Entername)
        val signIn=findViewById<TextView>(R.id.sign)


        signIn.setOnClickListener(){
            val tname=name.text.toString()
            if(tname.isNotEmpty()){
                readData(tname)
            }
            else{
                Toast.makeText(this,"Please enter User name",Toast.LENGTH_LONG).show()
            }

        }
    }

    private fun readData(tname: String) {
        dataBase=FirebaseDatabase.getInstance().getReference("Users")
        dataBase.child(tname).get().addOnSuccessListener {

            if(it.exists()){
                val email=it.child("email").value
                val name=it.child("name").value
                val userId=it.child("uniqueId").value
                val password=it.child("password").value
                val intent = Intent(this,HomeActivity::class.java)
                intent.putExtra(Key1,email.toString())
                intent.putExtra(Key2,name.toString())
                intent.putExtra(Key3,userId.toString())
                intent.putExtra(Key4,password.toString())
                startActivity(intent)

            }
            else{
                Toast.makeText(this,"User does not exist",Toast.LENGTH_LONG).show()
            }
        }.addOnFailureListener{
            Toast.makeText(this,"Failed",Toast.LENGTH_LONG).show()
        }

    }

}