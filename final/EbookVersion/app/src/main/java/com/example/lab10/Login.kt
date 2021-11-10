package com.example.lab10

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_login.*

class Login : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        loginBTN.setOnClickListener {
            startActivity(Intent(this,Service::class.java))
        }

        /*
            YOU FINISHED THE CREATE ACCOUNT PORTION
                    NOW
            GO TO PAGE 10-63 TO START THE LOG IN PORTION
         */
    }
}