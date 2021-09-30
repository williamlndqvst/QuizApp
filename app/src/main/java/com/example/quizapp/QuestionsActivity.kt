package com.example.quizapp

import android.content.Intent
import android.content.res.ColorStateList
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.util.Log
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.core.content.ContextCompat
import java.security.AccessController.getContext
import java.util.concurrent.TimeUnit

open class QuestionsActivity() : AppCompatActivity() {

    var answerButton1: Button? = null
    var answerButton2: Button? = null
    var answerButton3: Button? = null
    var answerButton4: Button? = null
    var heart1ImageView: ImageView? = null
    var heart2ImageView: ImageView? = null

    var remainingHearts: Int = 2
    var currentQuestion: Int = 0
    var questions: Array<Question> = emptyArray<Question>();
    var category: Category? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_questions)

        this.category = intent.getSerializableExtra("category") as Category
        this.questions = category!!.questions

        questions.shuffle();

        answerButton1 = findViewById<Button>(R.id.answerButton1)
        answerButton2 = findViewById<Button>(R.id.answerButton2)
        answerButton3 = findViewById<Button>(R.id.answerButton3)
        answerButton4 = findViewById<Button>(R.id.answerButton4)

        val score = findViewById<TextView>(R.id.scoreView)
        score.text = String.format(getString(R.string.score), Score.scorePoints.toString())

        answerButton1!!.setBackgroundColor(ContextCompat.getColor(this, category!!.color))
        answerButton2!!.setBackgroundColor(ContextCompat.getColor(this, category!!.color))
        answerButton3!!.setBackgroundColor(ContextCompat.getColor(this, category!!.color))
        answerButton4!!.setBackgroundColor(ContextCompat.getColor(this, category!!.color))

        heart1ImageView = findViewById(R.id.heart1ImageView)
        heart2ImageView = findViewById(R.id.heart2ImageView)

        setQuestion()

        answerButton1?.setOnClickListener {
            if (answerButton1?.text == questions[currentQuestion].rightAnswer) {
                answerButton1!!.setBackgroundColor(ContextCompat.getColor(this, R.color.green))
                updateScore()
                currentQuestion++
                Handler(getMainLooper()).postDelayed({
                    setQuestion()
                }, 750)

            } else {
                answerButton1!!.setBackgroundColor(ContextCompat.getColor(this, R.color.grey))
                remainingHearts -= 1
                checkRemainingHearts()
                checkIfHasHearts()
            }
        }
        answerButton2?.setOnClickListener {
            if (answerButton2?.text == questions[currentQuestion].rightAnswer) {
                answerButton2!!.setBackgroundColor(ContextCompat.getColor(this, R.color.green))
                updateScore()
                currentQuestion++
                Handler(getMainLooper()).postDelayed({
                    setQuestion()
                }, 750)
            } else {
                answerButton2!!.setBackgroundColor(ContextCompat.getColor(this, R.color.grey))
                remainingHearts -= 1
                checkRemainingHearts()
                checkIfHasHearts()

            }
        }
        answerButton3?.setOnClickListener {
            if (answerButton3?.text == questions[currentQuestion].rightAnswer) {
                answerButton3!!.setBackgroundColor(ContextCompat.getColor(this, R.color.green))
                updateScore()
                currentQuestion++
                Handler(getMainLooper()).postDelayed({
                    setQuestion()
                }, 750)
            } else {
                answerButton3!!.setBackgroundColor(ContextCompat.getColor(this, R.color.grey))
                remainingHearts -= 1
                checkRemainingHearts()
                checkIfHasHearts()
            }
        }
        answerButton4?.setOnClickListener {
            if (answerButton4?.text == questions[currentQuestion].rightAnswer) {
                answerButton4!!.setBackgroundColor(ContextCompat.getColor(this, R.color.green))
                updateScore()
                currentQuestion++
                Handler(getMainLooper()).postDelayed({
                    setQuestion()
                }, 750)
            } else {
                answerButton4!!.setBackgroundColor(ContextCompat.getColor(this, R.color.grey))
                remainingHearts -= 1
                checkRemainingHearts()
                checkIfHasHearts()
            }
        }

    }

    fun updateScore() {
        var score = findViewById<TextView>(R.id.scoreView)
        Score.scorePoints += 20
        score.text = String.format(getString(R.string.score), Score.scorePoints.toString())
        Score.correctAnswers += 1
    }

    private fun setQuestion() {
        if (currentQuestion >= questions.size-1) {
            Score.answeredCategories.add(category!!.name)
            val intent = Intent(this, CategoryQuestionActivity::class.java)
            startActivity(intent)
            return
        }

        var question = questions[currentQuestion]

        var sTextView = findViewById<TextView>(R.id.sTextView)

        sTextView!!.text = question.question

        question.answers.shuffle()

        answerButton1!!.setBackgroundColor(ContextCompat.getColor(this, category!!.color))
        answerButton2!!.setBackgroundColor(ContextCompat.getColor(this, category!!.color))
        answerButton3!!.setBackgroundColor(ContextCompat.getColor(this, category!!.color))
        answerButton4!!.setBackgroundColor(ContextCompat.getColor(this, category!!.color))

        answerButton1!!.text = question.answers[0]
        answerButton2!!.text = question.answers[1]
        answerButton3!!.text = question.answers[2]
        answerButton4!!.text = question.answers[3]

    }

    fun checkRemainingHearts() {
        if (remainingHearts == 1) {
            heart2ImageView?.setColorFilter(resources.getColor(R.color.grey)); // Add tint color
        }
        if (remainingHearts == 0) {
            heart1ImageView?.setColorFilter(resources.getColor(R.color.grey)); // Add tint color
        }
    }

    fun checkIfHasHearts() {
        if (remainingHearts == 0) {
            TimeUnit.MILLISECONDS.sleep(1L)
            startRestartScreenActivity()
        }
    }

    fun startRestartScreenActivity() {

        val intent = Intent(this, RestartScreenActivity::class.java)
        startActivity(intent)

    }
}
