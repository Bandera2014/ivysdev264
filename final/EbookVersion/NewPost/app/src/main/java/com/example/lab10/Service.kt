package com.example.lab10

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.android.synthetic.main.activity_service.*

class Service : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_service)

        readFireStoreData()
    }
    fun readFireStoreData(){
        readCountryId.setText("")
        val db = FirebaseFirestore.getInstance()
        //Customer: is your database collection name.  It is case sensitive.
        db.collection("Customer").get().addOnCompleteListener{
            val result:  StringBuffer = StringBuffer()
            if(it.isSuccessful){

                for(document in it.result!!){
//                    Log.d("readFireStoreData", document.toString())
//                    Log.d("readFireStoreData", document.data.toString())
//                    Log.d("readFireStoreData", document.data.getValue("Country",) as String)
//                    Log.d("readFireStoreData", document.data.getValue("Country",).toString())
//                    Log.d("readFireStoreData", document.data.getValue("City",).toString())
//                    Log.d("readFireStoreData", document.data.getValue("Phone Number",).toString())
//                    Log.d("readFireStoreData", document.data.getValue("Name",).toString())
                    //for "Country" use the same spelling which you have used before in the
                    // Signup file.append("    "):  to make a space btwn country values' results.

                    result.append(document.data.getValue("Country")).append("     ")
                }
                readCountryId.setText(result)
            }
        }
    }
}