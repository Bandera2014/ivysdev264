package com.example.lab07

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun mySchedule(view: View){
        var intent = Intent(this,Confirm::class.java)
        intent.putExtra("name",nameId.text.toString())
        intent.putExtra("address",addressId.text.toString())
        intent.putExtra("city",cityId.text.toString())
        intent.putExtra("stateId",stateId.text.toString())
        intent.putExtra("zipCode",zipId.text.toString())
        intent.putExtra("country",countryId.text.toString())
        startActivity(intent)
    }
}