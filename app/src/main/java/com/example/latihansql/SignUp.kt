package com.example.latihansql

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.PersistableBundle
import android.text.TextUtils
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class SignUp : AppCompatActivity() {
    private lateinit var uname: EditText
    private lateinit var psword: EditText
    private lateinit var rpsword: EditText
    private lateinit var btnSubmit: Button
    private lateinit var db: DBHelper

    @SuppressLint("MissingInflateId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up)

        uname = findViewById(R.id.editTextTextPersonName)
        psword = findViewById(R.id.editTextTextPassword3)
        rpsword = findViewById(R.id.editTextTextPassword2)
        btnSubmit = findViewById(R.id.button3)
        db = DBHelper(this)

        btnSubmit.setOnClickListener{
            val intent = Intent(applicationContext, SignIn::class.java)
            val unameText = uname.text.toString()
            val pwordText = psword.text.toString()
            val rpwordText = rpsword.text.toString()
            val savedata = db.insertdata(unameText, pwordText)

            if (TextUtils.isEmpty(unameText) || TextUtils.isEmpty(pwordText) || TextUtils.isEmpty(rpwordText)){
                Toast.makeText(this, "Isi Inputannya!!", Toast.LENGTH_SHORT).show()

            }else{
                if (pwordText.equals(rpwordText)){
                    if (savedata){
                        Toast.makeText(this,"Daftar Berhasil!!", Toast.LENGTH_SHORT).show()
                        startActivity(intent)
                    }else{
                        Toast.makeText(this,"User Udah Ada Woi!! Ganti!", Toast.LENGTH_SHORT).show()
                    }
                }else{
                    Toast.makeText(this, "Password dan Confirm Password Tidak Cocok", Toast.LENGTH_SHORT).show()
                }
            }
        }

    }

}