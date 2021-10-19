package com.example.multiple_activity

import android.content.DialogInterface
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import kotlinx.android.synthetic.main.activity_newpage.*

class newpage : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_newpage)
        val name=intent.getStringExtra("name")
        val location=intent.getStringExtra("location")
        val mobile=intent.getStringExtra("mobile")
        val mail=intent.getStringExtra("mail")
        val msg=textView.text
        textView.text=("${name} \n ${location} \n${mobile} \n${mail}")
        button2.setOnClickListener {
            AlertDialog.Builder(this)
                .setMessage(textView.text)
                .setPositiveButton("Confirm", DialogInterface.OnClickListener { dialogInterface, i ->
                    val i= Intent(this,Activity3::class.java)
                    i.putExtra("name",name)
                    i.putExtra("location",location)
                    i.putExtra("mobile",mobile)
                    i.putExtra("mail",mail)
                    startActivity(i)
                } )
                .show()
        }
    }
}