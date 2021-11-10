package com.example.lab10

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.snackbar.Snackbar
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.activity_signup.*

class Signup : AppCompatActivity() {
    private lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_signup)

        auth = FirebaseAuth.getInstance()

        createBTN.setOnClickListener {
            if(emailSignupId.text.trim().toString().isNotEmpty()
                || passwordSignupId.text.trim().toString().isNotEmpty()){
                createUser(emailSignupId.text.trim().toString(),passwordSignupId.text.trim().toString())
            }
            else{
                Log.d("CreateAccountE", emailSignupId.text.trim().toString().isNotEmpty().toString())
                Log.d("CreateAccountP", passwordSignupId.text.trim().toString().isNotEmpty().toString())
                Snackbar.make(findViewById(R.id.createBTN),
                "Check your username and password then try again",
                Snackbar.LENGTH_LONG).show()
            }

        }
    }

    fun createUser(email: String, password:String){
        auth.createUserWithEmailAndPassword(email,password).addOnCompleteListener(this){
            task->
            if(task.isSuccessful){
                startActivity(Intent(this,ThankYou::class.java))
            }
            else{
                Snackbar.make(findViewById(R.id.createBTN),
                "Enter a valid username and password (6 characters)",
                Snackbar.LENGTH_LONG).show()
            }
        }
    }
}