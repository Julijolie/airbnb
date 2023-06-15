package com.airbnb

import android.content.Intent
import android.net.wifi.p2p.WifiP2pManager.DnsSdTxtRecordListener
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class FinalActivity : AppCompatActivity() {
    private lateinit var name: String
    private lateinit var email: String
    private lateinit var phone: String
    private lateinit var address: String
    private lateinit var numberOfPerson: String
    private lateinit var txtCheckin: String
    private lateinit var txtCheckout: String
    private lateinit var numberOfRooms: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_final)
        val textView: TextView = findViewById(R.id.txt1)

        val intent: Intent = intent
        name = intent.getStringExtra("nome:").toString()
        address = intent.getStringExtra("Endereço:").toString()
        phone = intent.getStringExtra("telefone:").toString()
        numberOfPerson = intent.getStringExtra("n of person:").toString()
        email = intent.getStringExtra("e-mail:").toString()
        txtCheckin = intent.getStringExtra("Check-in:").toString()
        txtCheckout = intent.getStringExtra("Check-out:").toString()
        numberOfRooms = intent.getStringExtra("numberOfRooms:").toString()

        textView.text = (
                "name: $name" +
                        "\naddress: $address" +
                        "\nphone: $phone" +
                        "\nnumberOfPerson: $numberOfPerson" +
                        "\nemail: $email" +
                        "\ntxtCheckin: $txtCheckin" +
                        "\ntxtCheckout: $txtCheckout" +
                        "\nnumberOfRooms: $numberOfRooms"
                )
    }
}
