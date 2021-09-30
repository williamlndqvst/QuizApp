package com.example.quizapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class RestartScreenActivity : AppCompatActivity() {

    var scoreView: TextView? = null
    var finalTextView: TextView? = null
    var restartButton: Button? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_restart_screen)

        finalTextView = findViewById(R.id.finalTextView);
        scoreView = findViewById(R.id.scoreView)
        restartButton = findViewById(R.id.restartButton)

        scoreView!!.text = String.format(getString(R.string.score), Score.scorePoints.toString())

        restartButton!!.setOnClickListener {
            Score.answeredCategories = mutableListOf<String>()
            Score.correctAnswers = 0
            Score.scorePoints = 0
            startCategoryQuestionActivity()
        }

        if (Score.answeredCategories.size == 4) {
            finalTextView!!.text = getString(R.string.you_won)
        } else {
            finalTextView!!.text = getString(R.string.you_lost)
        }
    }

    fun startCategoryQuestionActivity() {
        val intent = Intent(this, CategoryQuestionActivity::class.java)
        startActivity(intent)
    }
}