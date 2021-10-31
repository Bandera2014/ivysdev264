package com.androidatc.lab10

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

import com.google.firebase.auth.ktx.auth
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.ktx.Firebase
import kotlinx.android.synthetic.main.activity_service.*


class Service : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_service)

        readFireStoreData()

    }

    fun readFireStoreData() {
        val db = FirebaseFirestore.getInstance()

        // Customer: is your database collection name. It is case sensitive !!!
        db.collection("Customer")
            .get()
            .addOnCompleteListener {
                val result: StringBuffer = StringBuffer()
                if (it.isSuccessful) {
                    for (document in it.result!!) {
                        // for "Country" use the same spelling which you have used before in the Signup file.
                            // append("      "): to make a space between country values' results.
                        result.append(document.data.getValue("Country")).append("      ")

                    }
                    readCountryId.setText(result)
                }

            }
    }
}