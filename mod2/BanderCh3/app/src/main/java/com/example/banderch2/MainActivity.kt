package com.example.banderch2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        var itStudent=Student("Terry","Jeffards","1901 Lynch Rd",
                "Evansville","IN",47725,3.5,"CS")

        Log.d("student: ",itStudent.toString())
        class Teacher(s: String, s1: String, s2: String, s3: String, s4: String, s5: String, s6: String) :Student()
        var itTeacher=Teacher("first","last","add","city","state","zip","maj")
        Log.d("studentTeacher: ",itTeacher.toString())

    }
}