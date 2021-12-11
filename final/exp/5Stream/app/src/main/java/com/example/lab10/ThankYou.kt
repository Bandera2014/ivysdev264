package com.example.lab10

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_thankyou.*

class ThankYou: AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_thankyou)

        portalBtn.setOnClickListener {
            startActivity(Intent(this,Login::class.java))
        }

    }
}