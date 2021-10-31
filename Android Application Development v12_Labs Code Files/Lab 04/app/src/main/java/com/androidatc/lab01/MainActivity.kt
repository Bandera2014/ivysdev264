package com.androidatc.lab01

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val n1=Number1.text
        val n2=Number2.text
        button_plus.setOnClickListener {
            val sumResult= n1.toString().toDouble()+ n2.toString().toDouble()
            result_view.text= sumResult.toString()
        }

        button_minus.setOnClickListener {
            val sumResult= n1.toString().toDouble()- n2.toString().toDouble()
            result_view.text= sumResult.toString()
        }

        button_multiply.setOnClickListener {
            val sumResult= n1.toString().toDouble()* n2.toString().toDouble()
            result_view.text= sumResult.toString()
        }

        button_divide.setOnClickListener {
            val sumResult= n1.toString().toDouble()/ n2.toString().toDouble()
            result_view.text= sumResult.toString()
        }
    }
}





