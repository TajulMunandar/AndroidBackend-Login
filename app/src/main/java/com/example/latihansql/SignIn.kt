package com.example.latihansql

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class SignIn : AppCompatActivity() {

    private lateinit var edituname: EditText
    private lateinit var editpword: EditText
    private lateinit var loginbtn: Button
    private lateinit var dbh: DBHelper

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_in)

        loginbtn = findViewById(R.id.button4)
        edituname = findViewById(R.id.editTextTextPersonName3)
        editpword = findViewById(R.id.editTextTextPassword)
        dbh = DBHelper(this)

        loginbtn.setOnClickListener{

            val editunam = edituname.text.toString()
            val editpwd = editpword.text.toString()
            val checkuser =dbh.checkuserpass(editunam, editpwd)

            if (TextUtils.isEmpty(editunam) || TextUtils.isEmpty(editpwd)){
                Toast.makeText(this, "Add Username & Password", Toast.LENGTH_SHORT).show()
            }else{
                if (checkuser==true){
                    Toast.makeText(this, "Login SuccessFull!!", Toast.LENGTH_SHORT).show()
                    val intent = Intent(applicationContext, success::class.java)
                    startActivity(intent)
                }
                else{
                    Toast.makeText(this, "Wrong Username Or Password", Toast.LENGTH_SHORT).show()
                }
            }
        }


    }
}