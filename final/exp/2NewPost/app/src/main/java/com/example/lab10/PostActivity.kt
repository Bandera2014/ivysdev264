package com.example.lab10

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.core.content.ContextCompat.startActivity
import com.google.android.material.snackbar.Snackbar
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.ktx.Firebase
import kotlinx.android.synthetic.main.activity_post.*
import android.content.Intent as Intent

class PostActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_post)

        submitBTN.setOnClickListener {
            uploadData()
            startActivity(Intent(this,Service::class.java))
        }


    }
}

private fun uploadData(){
    val fireStoreDatabase = FirebaseFirestore.getInstance()
    val hashMap = hashMapOf<String,Any>(
        "name" to "John",
        "city" to "Nairobi",
        "age" to 24
    )

    fireStoreDatabase.collection("test")
        .add(hashMap)
        .addOnSuccessListener {
            Log.d("PostPushing","Success!  Huzzah!")

        }
        .addOnFailureListener{ exception ->
            Log.d("PostPushing","Failure!  Booooo!")
        }

}