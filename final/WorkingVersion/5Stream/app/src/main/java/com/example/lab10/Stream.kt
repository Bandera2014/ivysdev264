package com.example.lab10

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.android.synthetic.main.activity_stream.*

class Stream : AppCompatActivity() {

    var adapter:StreamAdapter?=null
    var postList:ArrayList<Post>?=null
    var layoutManager:RecyclerView.LayoutManager?=null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_stream)

        postList=ArrayList<Post>()
        layoutManager=LinearLayoutManager(this)
        adapter= StreamAdapter(postList!!,this)

        myRecyclerView.layoutManager=layoutManager
        myRecyclerView.adapter=adapter


        fab.setOnClickListener {
            startActivity(Intent(this,PostActivity::class.java))
        }

        readFireStoreData()
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.main_menu,menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId){
//            R.id.action_settings -> Toast.makeText(this,"Settings",Toast.LENGTH_SHORT).show()
            R.id.action_settings -> startActivity(Intent(this,Settings::class.java))
        }
        return super.onOptionsItemSelected(item)
    }

    fun readFireStoreData(){
//        readCountryId.setText("")
        val db = FirebaseFirestore.getInstance()
        //Customer: is your database collection name.  It is case sensitive.
        db.collection("Post").get().addOnCompleteListener{
            val result:  StringBuffer = StringBuffer()
            if(it.isSuccessful){

                for(document in it.result!!){
                    /*
                        Log.d("readFireStoreData", document.toString())
                        Log.d("readFireStoreData", document.data.toString())
                        Log.d("readFireStoreData", document.data.getValue("Country",) as String)
                        Log.d("readFireStoreData", document.data.getValue("Country",).toString())
                        Log.d("readFireStoreData", document.data.getValue("City",).toString())
                        Log.d("readFireStoreData", document.data.getValue("Phone Number",).toString())
                        Log.d("readFireStoreData", document.data.getValue("Name",).toString())
                        //for "Country" use the same spelling which you have used before in the
                        // Signup file.append("    "):  to make a space btwn country values' results.
                    */

                    Log.d("PostClassImplement",Post(document.data.getValue("name").toString(),
                        document.data.getValue("name").toString()
                    ).toString())


                    postList!!.add(Post(
                        document.data.getValue("name") as String,
                        document.data.getValue("desc") as String
                    ))
                }
//                readCountryId.setText(result)
            }
        }
        adapter!!.notifyDataSetChanged()
    }
}