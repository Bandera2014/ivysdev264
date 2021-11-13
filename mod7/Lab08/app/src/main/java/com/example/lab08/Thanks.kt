package com.example.lab08

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_thanks.*

class Thanks : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_thanks)

        nameId.text=intent.getStringExtra("name")
        phoneId.text=intent.getStringExtra("phoneNumber")
        sizeId.text=intent.getStringExtra("pizzaSize")
        dateId.text=intent.getStringExtra("pickupDate")
        timeId.text=intent.getStringExtra("pickupTime")

        sendBTN.setOnClickListener {
            rateText.text = myRatingBar.rating.toString()
        }

    }
}