package com.example.banderch2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        for (i in 0..9){  //0 through 9 for 10 iterations and stay with proper CS index #
            Log.d("hw",("index: "+i.toString()))
        }
        Log.d("hw","We have exited the first loop")

        for (i in 0..9){  //0 through 9 for 10 iterations and stay with proper CS index #
            if (i==5){
                break
            }
            else {
                Log.d("hw", ("index: " + i.toString()))
            }
        }
        Log.d("hw","We have exited the second loop")

        Log.d("hw","The application is complete...")

    }


}
