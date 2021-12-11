package com.example.lab10

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatDelegate
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.activity_settings.*

class Settings : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_settings)

        deleteBTN.setOnClickListener {
            Toast.makeText(this,"Feature coming soon!",Toast.LENGTH_SHORT).show()
        }

        logoutBTN.setOnClickListener {
            FirebaseAuth.getInstance().signOut()
            startActivity(Intent(this,Login::class.java))
        }

//        https://www.geeksforgeeks.org/how-to-create-a-dark-mode-for-a-custom-android-app-in-kotlin/
        modeSwitch.setOnCheckedChangeListener{ _, isChecked ->
            if (modeSwitch.isChecked) {
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
                modeSwitch.text = "Disable dark mode"
            }
            else {
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
                modeSwitch.text = "Enable dark mode"
            }
        }

    }
}