package com.example.banderfinal

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.account.*

class Account:AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.account)

        updateBTN.setOnClickListener {
            var intent = Intent(this,Stream::class.java)
            startActivity(intent)
        }
    }
}