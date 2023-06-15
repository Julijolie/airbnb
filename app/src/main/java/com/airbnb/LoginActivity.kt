package com.airbnb

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity

class LoginActivity : AppCompatActivity() {
    private lateinit var btnEnviar: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        val information = intent.getStringExtra("Info")
        val textView = findViewById<TextView>(R.id.textView2)
        textView.text = "Quarto escolhido: "+information

        btnEnviar = findViewById(R.id.btnEnviar)
        btnEnviar.setOnClickListener {
            val i = Intent(this@LoginActivity, PersonnelInfoActivity::class.java)
            startActivity(i)
        }
    }
}
