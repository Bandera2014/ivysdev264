package com.example.android_calculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var n1 = editNumber1.text.toString()
        var n2 = editNumber2.text.toString()

        plusBTN.setOnClickListener{
            var sumResults = n1 + n2
            resultView.text = sumResults
            Log.d("please work",sumResults)
        }

        minusBTN.setOnClickListener{
            var minusResults = n1 + n2
            resultView.text = minusResults
            Log.d("please work",minusResults)
        }

        multiplyBTN.setOnClickListener{
            var multiplyResults = n1 + n2
            resultView.text = multiplyResults
            Log.d("please work",multiplyResults)
        }

        divideBTN.setOnClickListener{
            var divideResults = n1 + n2
            resultView.text = divideResults
            Log.d("please work",divideResults)
        }
    }
}