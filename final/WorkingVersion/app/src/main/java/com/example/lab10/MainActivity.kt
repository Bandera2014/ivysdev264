package com.example.lab10

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        signupBTN.setOnClickListener{
            startActivity(Intent(this,Signup::class.java))
        }
        loginBTN.setOnClickListener {
            startActivity(Intent(this,Login::class.java))
        }
    }
}