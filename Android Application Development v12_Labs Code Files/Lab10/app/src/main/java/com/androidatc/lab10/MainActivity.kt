package com.androidatc.lab10

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        signupBtn.setOnClickListener {
            startActivity(Intent(this, Signup::class.java))
        }

        loginBtn.setOnClickListener {
            startActivity(Intent(this, Login::class.java))

        }
    }
}