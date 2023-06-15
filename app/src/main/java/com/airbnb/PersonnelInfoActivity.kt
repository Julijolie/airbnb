package com.airbnb

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity


class PersonnelInfoActivity : AppCompatActivity() {
    private lateinit var edAddress: EditText
    private lateinit var edName: EditText
    private lateinit var edPhone: EditText
    private lateinit var edMail: EditText
    private lateinit var edNumber: EditText
    private lateinit var btnNext: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_personal_info)

        btnNext = findViewById(R.id.bntNext)
        edAddress = findViewById(R.id.edAddress)
        edName = findViewById(R.id.edName)
        edPhone = findViewById(R.id.edPhone)
        edMail = findViewById(R.id.edMail)
        edNumber = findViewById(R.id.edNumber)

        btnNext.setOnClickListener {
            val i = Intent(this@PersonnelInfoActivity, RoomInfoActivity::class.java)
            i.putExtra("name", edName.text.toString())
            i.putExtra("address", edAddress.text.toString())
            i.putExtra("phone", edPhone.text.toString())
            i.putExtra("email", edMail.text.toString())
            i.putExtra("numberofperson", edNumber.text.toString())
            startActivity(i)
        }
    }
}
