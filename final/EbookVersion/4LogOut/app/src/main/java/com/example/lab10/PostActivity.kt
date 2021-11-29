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

            var n = nameTXT.text.toString()
            var d = descTXT.text.toString()

            uploadData(n,d)
            startActivity(Intent(this,Service::class.java))
        }
    }
}

private fun uploadData(name:String,desc:String){
    val fireStoreDatabase = FirebaseFirestore.getInstance()

    var p = Post(name,desc)

    val hashMap = hashMapOf<String,Any>(
        "name" to "John",
        "city" to "Nairobi",
        "age" to 24
    )

    fireStoreDatabase.collection("Post")
        .add(p)
        .addOnSuccessListener {
            Log.d("PostPushing","Success!  Huzzah!")

        }
        .addOnFailureListener{ exception ->
            Log.d("PostPushing","Failure!  Booooo!")
        }

}