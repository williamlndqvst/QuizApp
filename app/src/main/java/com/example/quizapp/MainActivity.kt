package com.example.quizapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val button = findViewById<Button>(R.id.startButton)

        button.setOnClickListener {
            startCategoryQuestionActivity()
        }

    }


     fun startCategoryQuestionActivity() {

         Log.e("!!!", "hej")

        val intent = Intent(this, CategoryQuestionActivity::class.java)
        startActivity(intent)

    }
}