package com.example.android_8_lab_05

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_main.view.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun onPlaceOrderButtonClicked(view: View){
        var pizzaSizePrice = 0.0
        var toppingsTotal = 0.0
        when{
            radioGroup.smallPizza.isChecked -> pizzaSizePrice = 5.0
            radioGroup.mediumPizza.isChecked -> pizzaSizePrice = 7.0
            radioGroup.largePizza.isChecked -> pizzaSizePrice = 9.0
        }

        if(onionsCheckBox.isChecked){toppingsTotal+=1}
        if(olivesCheckBox.isChecked){toppingsTotal+=2}
        if(tomatoesCheckBox.isChecked){toppingsTotal+=3}

        totalPrice.text = "Total Order Price = $"+ (pizzaSizePrice+toppingsTotal)+"0"
    }
}