package com.example.androidcalc2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    lateinit var number1: EditText
    lateinit var number2: EditText
    lateinit var results: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        number1 = findViewById(R.id.editNumber1)
        number2 = findViewById(R.id.editNumber2)
        results = findViewById(R.id.resultView)

        var plus = findViewById<Button>(R.id.plusBTN)
        var minus = findViewById<Button>(R.id.minusBTN)
        var multiply = findViewById<Button>(R.id.multiplyBTN)
        var divide = findViewById<Button>(R.id.divideBTN)

        plus.setOnClickListener{
            var n1 = number1.text.toString().toDouble()
            var n2 = number2.text.toString().toDouble()

            var sum = n1+n2
            Log.d("outputTest",sum.toString())
            results.text = sum.toString()
        }

        minus.setOnClickListener{
            var n1 = number1.text.toString().toDouble()
            var n2 = number2.text.toString().toDouble()

            var dif = n1-n2
            Log.d("outputTest",dif.toString())
            results.text = dif.toString()
        }

        multiply.setOnClickListener{
            var n1 = number1.text.toString().toDouble()
            var n2 = number2.text.toString().toDouble()

            var mul = n1*n2
            Log.d("outputTest",mul.toString())
            results.text = mul.toString()
        }

        divide.setOnClickListener{
            var n1 = number1.text.toString().toDouble()
            var n2 = number2.text.toString().toDouble()

            var div = n1/n2
            Log.d("outputTest",div.toString())
            results.text = div.toString()
        }
    }
}