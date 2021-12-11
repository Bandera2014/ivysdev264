package com.example.lab10

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.snackbar.Snackbar
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.activity_login.*

class Login : AppCompatActivity() {
    lateinit var auth: FirebaseAuth
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        auth=FirebaseAuth.getInstance()

        loginBTN.setOnClickListener {
            if(emailLoginId.text.trim().toString().isNotEmpty() ||
                    passwordLoginId.text.trim().toString().isNotEmpty()){
                login(emailLoginId.text.trim().toString(), passwordLoginId.text.trim().toString())
            }
            else{
                Snackbar.make(findViewById(R.id.loginBTN),
                "check your username or password then try again",
                Snackbar.LENGTH_LONG).show()
            }
        }
    }
    fun login(email:String,password:String){
        auth.signInWithEmailAndPassword(email,password).addOnCompleteListener(this){
            task->
            if (task.isSuccessful){
                startActivity(Intent(this,Stream::class.java))
            }
            else{
                Snackbar.make(findViewById(R.id.loginBTN),
                "Enter a valid username and password",
                Snackbar.LENGTH_LONG).show()
            }
        }
    }
}