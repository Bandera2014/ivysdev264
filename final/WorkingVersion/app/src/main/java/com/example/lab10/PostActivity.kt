package com.example.lab10

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.android.synthetic.main.activity_post.*
import android.content.Intent as Intent

class PostActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_post)

        var progressBarStatus=0
        var rate=0

        submitBTN.setOnClickListener {

            var n = nameTXT.text.toString()
            var d = descTXT.text.toString()

            uploadData(n,d)

            Thread(Runnable{
                while(progressBarStatus<100){
                    try{
                        rate+=10
                        Thread.sleep(500)
                    }
                    catch(e: InterruptedException){
                        e.printStackTrace()
                    }
                    progressBarStatus=rate
                    progressBar.progress=progressBarStatus
                }
                startActivity(Intent(this,Stream::class.java))
            }).start()
        }
    }
}

private fun uploadData(name:String,desc:String){
    val fireStoreDatabase = FirebaseFirestore.getInstance()

    var p = Post(name,desc,"0")

    /*
        val hashMap = hashMapOf<String,Any>(
            "name" to "John",
            "city" to "Nairobi",
            "age" to 24
        )
    */
    fireStoreDatabase.collection("Post")
        .add(p)
        .addOnSuccessListener {
            Log.d("PostPushing","Success!  Huzzah!")
        }
        .addOnFailureListener{ exception ->
            Log.d("PostPushing","Failure!  Booooo!")
        }

    val db = FirebaseFirestore.getInstance()
    db.collection("Post").get().addOnCompleteListener{
        if(it.isSuccessful){
            var key = ""
            for(document in it.result!!){
                if (document.data.getValue("id").equals("0")){
                    p.setI(document.id)
                    key=document.id
                }
            }
            Log.d("ID issue",key)
            db.collection("Post").document(key).update("id",key)
        }
    }
}