package com.example.banderfinal

import android.content.Intent
import android.os.Bundle
import android.os.PersistableBundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class Stream: AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.stream)
        
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu,menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item?.itemId){
            R.id.newItem -> {
                Toast.makeText(this,"Item 1 is select",Toast.LENGTH_LONG).show()
                var intent = Intent(this,Account::class.java)
                startActivity(intent)
            }
            R.id.item2 -> {
                Toast.makeText(this,"Item 2 is select",Toast.LENGTH_LONG).show()
            }
            R.id.settingsItem -> {
                Toast.makeText(this,"Item 3 is select",Toast.LENGTH_LONG).show()
                var intent = Intent(this,Settings::class.java)
                startActivity(intent)
            }
        }

        return super.onOptionsItemSelected(item)
    }
}