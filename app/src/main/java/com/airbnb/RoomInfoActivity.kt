package com.airbnb

import android.app.DatePickerDialog
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Spinner
import androidx.appcompat.app.AppCompatActivity
import java.text.SimpleDateFormat
import java.util.*

import android.view.View
import android.widget.DatePicker
import java.util.*

class RoomInfoActivity : AppCompatActivity() {
    private lateinit var myCalendar: Calendar
    private lateinit var edittext: EditText
    private lateinit var edCheckout: EditText
    private lateinit var edNum: EditText
    private lateinit var name: String
    private lateinit var email: String
    private lateinit var phone: String
    private lateinit var address: String
    private lateinit var numberofperson: String
    private lateinit var spinnerType: Spinner
    private lateinit var btnPreview: Button
    private lateinit var roomType: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_room)

        val i: Intent = intent
        name = i.getStringExtra("name").toString()
        email = i.getStringExtra("email").toString()
        phone = i.getStringExtra("phone").toString()
        address = i.getStringExtra("address").toString()
        numberofperson = i.getStringExtra("numberofperson").toString()

        myCalendar = Calendar.getInstance()

        edittext = findViewById(R.id.edCheckin)
        edCheckout = findViewById(R.id.edCheckout)
        spinnerType = findViewById(R.id.spinnerType)
        btnPreview = findViewById(R.id.btnPreview)
        edNum = findViewById(R.id.edNum)

        btnPreview.setOnClickListener(View.OnClickListener {
            val i = Intent(this@RoomInfoActivity, FinalActivity::class.java)
            i.putExtra("nome", name)
            i.putExtra("Endereço", address)
            i.putExtra("telefone", phone)
            i.putExtra("e-mail", email)
            i.putExtra("RoomType", roomType)
            i.putExtra("Checkin", edittext.text.toString())
            i.putExtra("Checkout", edCheckout.text.toString())
            i.putExtra("num", edNum.text.toString())
            startActivity(i)
        })

        val date1 = DatePickerDialog.OnDateSetListener { _: DatePicker, year: Int, monthOfYear: Int, dayOfMonth: Int ->
            myCalendar.set(Calendar.YEAR, year)
            myCalendar.set(Calendar.MONTH, monthOfYear)
            myCalendar.set(Calendar.DAY_OF_MONTH, dayOfMonth)
            updateLabel(myCalendar, edittext)
        }

        edittext.setOnClickListener(View.OnClickListener {
            DatePickerDialog(
                this@RoomInfoActivity,
                date1,
                myCalendar.get(Calendar.YEAR),
                myCalendar.get(Calendar.MONTH),
                myCalendar.get(Calendar.DAY_OF_MONTH)
            ).show()
        })

        val date2 = DatePickerDialog.OnDateSetListener { _: DatePicker, year: Int, monthOfYear: Int, dayOfMonth: Int ->
            myCalendar.set(Calendar.YEAR, year)
            myCalendar.set(Calendar.MONTH, monthOfYear)
            myCalendar.set(Calendar.DAY_OF_MONTH, dayOfMonth)
            updateLabel(myCalendar, edCheckout)
        }

        edCheckout.setOnClickListener(View.OnClickListener {
            DatePickerDialog(
                this@RoomInfoActivity,
                date2,
                myCalendar.get(Calendar.YEAR),
                myCalendar.get(Calendar.MONTH),
                myCalendar.get(Calendar.DAY_OF_MONTH)
            ).show()
        })
    }

    private fun updateLabel(myCalendar: Calendar, editText: EditText) {
        val myFormat = "MM/dd/yy"
        val sdf = SimpleDateFormat(myFormat, Locale.US)
        editText.setText(sdf.format(myCalendar.time))
    }
}
