package com.example.multiple_activity

import android.app.Dialog
import android.content.DialogInterface
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AlertDialog
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_newpage.*

class Activity3 : AppCompatActivity() {
    var details = mutableListOf<String>()
    private lateinit var recyclerView: RecyclerView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_3)

        recyclerView = findViewById(R.id.rv)
        val name=intent.getStringExtra("name")
        val location=intent.getStringExtra("location")
        val mobile=intent.getStringExtra("mobile")
        val mail=intent.getStringExtra("mail")

        details.add("$name")
        details.add( "$location")
        details.add("$mobile")
        details.add("$mail")
        recyclerView.adapter = RVAdapter(this,details)
        recyclerView.layoutManager = LinearLayoutManager(this)


    }


    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu,menu)
        return true
    }

    fun home(item: MenuItem) {
        AlertDialog.Builder(this)
            .setMessage("Choose activity")
            .setPositiveButton("Home", DialogInterface.OnClickListener { dialogInterface, i ->
                val i= Intent(this,MainActivity::class.java)
                startActivity(i)

            } )
            .setNegativeButton("Exit", DialogInterface.OnClickListener { dialogInterface, i ->
                //finish()
                System.exit(0)
            })
            .show()

    }
    fun About(item: MenuItem) {
        AlertDialog.Builder(this)
            .setMessage("This is my app")
            .setPositiveButton("Ok", DialogInterface.OnClickListener { dialog, which -> dialog.cancel() })

            .show()
    }
}