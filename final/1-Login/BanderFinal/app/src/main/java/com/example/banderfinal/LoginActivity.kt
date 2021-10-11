package com.example.banderfinal

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import kotlinx.android.synthetic.main.login.*;

class LoginActivity : AppCompatActivity() {

    private var canLogIn = true

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.login)

        registerLBL.setOnClickListener{
            Log.d("newUserState", canLogIn.toString())
            if (canLogIn){
                registerLBL.text="Already a user?"
                loginBTN.text="Register!"
                canLogIn=false
            }
            else{
                registerLBL.text="New user?"
                loginBTN.text="Log in!"
                canLogIn=true
            }
        }

        loginBTN.setOnClickListener {
            Log.d("newUserState", canLogIn.toString())
            if (!canLogIn){
                register(usernameTXT.text.toString(), passwordTXT.text.toString())
            }
            else{
                login(usernameTXT.text.toString(), passwordTXT.text.toString())
            }
        }
    }

    private fun register(un: String, pw: String){
        Toast.makeText(this,"You're registered!",Toast.LENGTH_LONG);
        registerLBL.text="New user?"
        loginBTN.text="Log in!"
        canLogIn=true
    }

    private fun login(un: String, pw: String){
        Log.d("loginf(x)",un+"/"+pw)
        var masterUsername="b"
        var masterPassword="1"

        if (un.equals(masterUsername) && pw.equals(masterPassword)){
            Toast.makeText(this,"You're logged in!",Toast.LENGTH_SHORT);
            var intent = Intent(this,Stream::class.java)
            startActivity(intent)
        }
        else{
            Toast.makeText(this,"Wrong un or pw!",Toast.LENGTH_SHORT);
        }
    }
}