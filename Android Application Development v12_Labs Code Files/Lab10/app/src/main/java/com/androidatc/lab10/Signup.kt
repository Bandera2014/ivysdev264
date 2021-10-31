package com.androidatc.lab10

import android.content.ContentValues.TAG
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.google.android.material.snackbar.Snackbar
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import kotlinx.android.synthetic.main.activity_signup.*

class Signup : AppCompatActivity() {

    private lateinit var auth: FirebaseAuth

    val db = Firebase.firestore

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_signup)

        auth = FirebaseAuth.getInstance()

        createBtn.setOnClickListener(){
            if (emailSignupId.text.trim().toString().isNotEmpty()
                ||passwordSignupId.text.trim().toString().isNotEmpty()) {

                createUser(emailSignupId.text.trim().toString(),passwordSignupId.text.trim().toString())
                newCustomer()


            }

            else{
                Snackbar.make(findViewById(R.id. createBtn),
                    "check your username and password then try again",
                    Snackbar.LENGTH_LONG).show()
            }

        }

    }

    fun createUser(email: String, password: String) {
        auth.createUserWithEmailAndPassword(email, password)
            .addOnCompleteListener(this) { task ->

                if (task.isSuccessful) {
                    startActivity(Intent(this, Thankyou::class.java))
                }

                else {
                    Snackbar.make(
                        findViewById(R.id.createBtn),
                        "Enter a valid username and password (6 characters)",
                        Snackbar.LENGTH_LONG
                    ).show()
                }

            }
    }

    private fun newCustomer(){
        // Create a new customer
        val customer = hashMapOf(
            "Name" to nameId.text.toString().trim(),
            "City" to cityId.text.toString().trim(),
            "Country" to countryId.text.toString().trim(),
            "Phone Number" to phoneId.text.toString().trim()
        )
        // Add a new document with a generated ID.
        db.collection("Customer")
            .add(customer)
            .addOnSuccessListener { documentReference ->
                Log.d(TAG, "DocumentSnapshot added with ID: ${documentReference.id}")
            }
            .addOnFailureListener { e ->
                Log.w(TAG, "Error adding document", e)
            }
    }


}