package com.example.quizapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class RestartScreenActivity : AppCompatActivity() {

    var finalScoreTextView: TextView? = null

    open var scorePoints : Int= 0

    var restartButton: Button? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_restart_screen)


        finalScoreTextView = findViewById(R.id.finalScoreTextView)

        finalScoreTextView!!.text = scorePoints.toString()

        restartButton = findViewById<Button>(R.id.restartButton)

        restartButton!!.setOnClickListener {
            startCategoryQuestionActivity()
        }


    }


    fun startCategoryQuestionActivity() {

        val intent = Intent(this, CategoryQuestionActivity::class.java)
        startActivity(intent)

    }
}