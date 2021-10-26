package com.diazp.bisadiaturandroid.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.diazp.bisadiaturandroid.R
import com.diazp.bisadiaturandroid.helper.SharedPref

class LoginActivity : AppCompatActivity() {
    lateinit var s: SharedPref
    lateinit var btnProsesLogin: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        s = SharedPref(this)

        btnProsesLogin = findViewById(R.id.btnProsesLogin)

        btnProsesLogin.setOnClickListener {
            s.setStatusLogin(true)
        }
    }
}