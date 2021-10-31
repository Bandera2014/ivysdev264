package com.androidatc.lab10

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.android.material.snackbar.Snackbar
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.activity_login.*

class Login : AppCompatActivity() {

    lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        auth = FirebaseAuth.getInstance()

        loginBtn.setOnClickListener(){

            if (emailLoginId.text.trim().toString().isNotEmpty()
                ||passwordLoginId.text.trim().toString().isNotEmpty()){

                login(emailLoginId.text.trim().toString(),passwordLoginId.text.trim().toString()) }

            else{
                Snackbar.make(findViewById(R.id.loginBtn),
                    "check your username or password then try again",
                    Snackbar.LENGTH_LONG).show()
            }
        }
    }


    fun login(email: String, password: String) {

        auth.signInWithEmailAndPassword(email, password)
            .addOnCompleteListener(this) { task ->
                if (task.isSuccessful) {
                    startActivity(Intent(this, Service::class.java))

                } else {
                    Snackbar.make(
                        findViewById(R.id.loginBtn),
                        "Enter a valid username or password",
                        Snackbar.LENGTH_LONG
                    ).show()
                }

            }
    }
}

