package com.example.lab07

import android.content.Intent
import android.os.Bundle
import android.os.PersistableBundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_confirm.*

class Confirm: AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_confirm)

        SnameId.text=intent.getStringExtra("name")
        SaddressId.text=intent.getStringExtra("address")
        ScityId.text=intent.getStringExtra("city")
        SstateId.text=intent.getStringExtra("state")
        SzipId.text=intent.getStringExtra("zipCode")
        ScountryId.text=intent.getStringExtra("country")

    }
    fun accept(view: View){
        var agree = Intent(this,ThankYou::class.java)
        startActivity(agree)
    }
    fun edit(view: View){
        onBackPressed()
    }
}