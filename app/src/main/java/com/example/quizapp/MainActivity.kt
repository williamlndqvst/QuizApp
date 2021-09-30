package com.example.quizapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val button = findViewById<Button>(R.id.startButton)
        button.setOnClickListener {
            startCategoryQuestionActivity()
        }
    }

    private fun startCategoryQuestionActivity() {
        val intent = Intent(this, CategoryQuestionActivity::class.java)
        startActivity(intent)
    }

}
