package com.airbnb

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {
    private lateinit var btnDetalhesSuite: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnDetalhesSuite = findViewById(R.id.btnDetalhesSuite)
        btnDetalhesSuite.setOnClickListener {
            val i = Intent(this@MainActivity, LoginActivity::class.java)
            i.putExtra("Info", "Suíte ")
            startActivity(i)
        }
    }
}
