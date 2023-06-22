package com.airbnb

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.floatingactionbutton.FloatingActionButton

class FinalActivity : AppCompatActivity() {
    private lateinit var name: String
    private lateinit var phone: String
    private lateinit var address: String
    private lateinit var numberOfPerson: String
    private lateinit var txtCheckin: String
    private lateinit var txtCheckout: String
    private lateinit var numberOfRooms: String
    private lateinit var roomType: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_final)
        val textView: TextView = findViewById(R.id.txt1)

        val intent: Intent = intent
        name = intent.getStringExtra("nome").toString()
        address = intent.getStringExtra("Endereço").toString()
        phone = intent.getStringExtra("telefone").toString()
        numberOfRooms = intent.getStringExtra("Número do quarto: ").toString()
        numberOfPerson = intent.getStringExtra("num").toString()
        txtCheckin = intent.getStringExtra("Checkin").toString()
        txtCheckout = intent.getStringExtra("Checkout").toString()
        roomType = intent.getStringExtra("RoomType").toString()

        textView.text = (
                "nome: $name" +
                        "\nEndereço: $address" +
                        "\nTelefone: $phone" +
                        "\nnúmero de pessoas: $numberOfPerson" +
                        "\nCheck-in: $txtCheckin" +
                        "\nCheck-out: $txtCheckout" +
                        "\nTipo de quarto: $roomType"
                )

        val btnCall: FloatingActionButton = findViewById(R.id.btnCall)
        btnCall.setOnClickListener {
            chamada()
        }
    }

    private fun chamada() {
        val phoneNumber = "22070002"
        val intent = Intent(Intent.ACTION_DIAL, Uri.parse("tel:$phoneNumber"))
        startActivity(intent)
    }
}
