package com.example.banderfinal

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.util.Log
import android.view.View
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import kotlinx.android.synthetic.main.login.*;

class LoginActivity : AppCompatActivity() {

    private var canLogIn = true
    //Firebase references
    private var mDatabaseReference: DatabaseReference? = null
    private var mDatabase: FirebaseDatabase? = null
    private var mAuth: FirebaseAuth? = null

    private val TAG = "CreateAccountActivity"

    //global variables
    private var firstName: String? = null
    private var lastName: String? = null
    private var email: String? = null
    private var password: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.login)
        mDatabase = FirebaseDatabase.getInstance()
        mDatabaseReference = mDatabase!!.reference!!.child("Users")
        mAuth = FirebaseAuth.getInstance()

        registerLBL.setOnClickListener{
            Log.d("newUserState", canLogIn.toString())
            if (canLogIn){
                registerLBL.text="Already a user?"
                signInUpBTN.text="Register!"
                firstLBL.visibility= View.VISIBLE
                firstTXT.visibility= View.VISIBLE
                lastLBL.visibility= View.VISIBLE
                lastTXT.visibility= View.VISIBLE
                canLogIn=false
            }
            else{
                registerLBL.text="New user?"
                signInUpBTN.text="Log in!"
                firstLBL.visibility= View.INVISIBLE
                firstTXT.visibility= View.INVISIBLE
                lastLBL.visibility= View.INVISIBLE
                lastTXT.visibility= View.INVISIBLE
                canLogIn=true
            }
        }

        signInUpBTN.setOnClickListener {
            Log.d("newUserState", canLogIn.toString())
            if (!canLogIn){
                createNewAccount()
//                register(emailTXT.text.toString(), passwordTXT.text.toString())
            }
            else{
                createNewAccount()
                //login(emailTXT.text.toString(), passwordTXT.text.toString())
            }
        }


    }

    private fun register(un: String, pw: String){
        Toast.makeText(this,"You're registered!",Toast.LENGTH_LONG);
        registerLBL.text="New user?"
        signInUpBTN.text="Log in!"
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

    private fun createNewAccount(){
        firstName = emailTXT.text.toString()
        lastName = lastTXT.text.toString()
        email = emailTXT.text.toString()
        password = passwordTXT.text.toString()

        if (!(firstName!!.isEmpty()) && !(lastName!!.isEmpty())
                && !(email!!.isEmpty()) && !(password!!.isEmpty())) {
            Toast.makeText(this, "is empty works", Toast.LENGTH_SHORT).show()

        }
        else {
            Toast.makeText(this, "Enter all details", Toast.LENGTH_SHORT).show()
        }
    }

    private fun updateUserInfoAndUI() {

        //start next activity
        val intent = Intent(this@LoginActivity, LoginActivity::class.java)
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
        startActivity(intent)
    }
    private fun verifyEmail() {
        val mUser = mAuth!!.currentUser;
        mUser!!.sendEmailVerification()
                .addOnCompleteListener(this) { task ->

                    if (task.isSuccessful) {
                        Toast.makeText(this@LoginActivity,
                                "Verification email sent to " + mUser.getEmail(),
                                Toast.LENGTH_SHORT).show()
                    } else {
                        Log.e(TAG, "sendEmailVerification", task.exception)
                        Toast.makeText(this@LoginActivity,
                                "Failed to send verification email.",
                                Toast.LENGTH_SHORT).show()
                    }
                }
    }


}