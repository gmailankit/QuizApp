package com.example.quizapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
         btn_start.setOnClickListener {
             if (et_name.text.toString().isEmpty())
             {
                 Toast.makeText(this,"please enter your name",Toast.LENGTH_SHORT).show()
             }
             else
             {
                 val intent=Intent(this,Quiz::class.java)
                 intent.putExtra(Constants. USERNAME,et_name.text.toString())
                 startActivity(intent)
                 finish()
             }
         }

    }
}