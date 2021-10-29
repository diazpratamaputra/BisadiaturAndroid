package com.diazp.bisadiaturandroid.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.diazp.bisadiaturandroid.R
import com.diazp.bisadiaturandroid.helper.SharedPref

class MasukActivity : AppCompatActivity() {
    lateinit var s: SharedPref
    lateinit var btnProsesLogin: Button
    lateinit var btnProsesRegister: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_masuk)

        s = SharedPref(this)

        mainButton()
    }

    private fun mainButton() {
        btnProsesLogin = findViewById(R.id.btnProsesLogin)
        btnProsesRegister = findViewById(R.id.btnProsesRegister)

        btnProsesLogin.setOnClickListener {
            s.setStatusLogin(true)
        }

        btnProsesRegister.setOnClickListener {
            startActivity(Intent(this, RegisterActivity::class.java))
        }
    }
}