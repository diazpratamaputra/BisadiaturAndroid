package com.diazp.bisadiaturandroid.activity

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.diazp.bisadiaturandroid.R
import com.diazp.bisadiaturandroid.app.ApiConfig
import com.diazp.bisadiaturandroid.model.ResponseModel
import kotlinx.android.synthetic.main.activity_register.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class RegisterActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        btn_register.setOnClickListener { register() }
        btn_google.setOnClickListener { dataDummy() }
    }

    private fun dataDummy() {
        et_nama.setText("Asep")
        et_email.setText("asep@gmail.com")
        et_phone.setText("089870696543")
        et_password.setText("SuperIdol")
    }

    fun register() {
        if (et_nama.text.isEmpty()) {
            et_nama.error = "Kolom nama tidak boleh kosong."
            et_nama.requestFocus()
            return
        } else if (et_email.text.isEmpty()) {
            et_email.error = "Kolom email tidak boleh kosong."
            et_email.requestFocus()
            return
        } else if (et_phone.text.isEmpty()) {
            et_phone.error = "Kolom nomor telepon tidak boleh kosong."
            et_phone.requestFocus()
            return
        } else if (et_password.text.isEmpty()) {
            et_password.error = "Kolom password tidak boleh kosong."
            et_password.requestFocus()
            return
        }

        ApiConfig.instanceRetrofit.register(et_nama.text.toString(), et_email.text.toString(), et_password.text.toString()).enqueue(object : Callback<ResponseModel>{
            override fun onResponse(call: Call<ResponseModel>, response: Response<ResponseModel>) {
                //Handle ketika sukses
                val respon = response.body()!!

                if (respon.success == 1) {
                    //Berhasil
                    Toast.makeText(this@RegisterActivity, "Selamat datang "+respon.user.name+"!", Toast.LENGTH_SHORT).show()
                } else {
                    //Gagal
                    Toast.makeText(this@RegisterActivity, "Error : "+respon.message, Toast.LENGTH_SHORT).show()
                }
            }

            override fun onFailure(call: Call<ResponseModel>, t: Throwable) {
                //Handle ketika gagal
                Toast.makeText(this@RegisterActivity, "Error : "+t.message, Toast.LENGTH_SHORT).show()
            }

        })
    }
}