package com.example.quizapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {

/*
        var gQ1answers: Array<String> = arrayOf("Kina", "Ryssland", "USA", "Indien")
        val gQ1 = Question("Vilket är världens största land?", gQ1answers, "Ryssland" )

        var geographyQuestions: Array<Question> = arrayOf(gQ1,)
        val geographyCategory: Category = Category("Geography", geographyQuestions)

        var gQ2answers: Array<String> = arrayOf("Monaco", "Liechtenstein", "Vatikanstaten", "San Marino")
        val gQ2 = Question("Vilket är världens minsta land sett till yta?", gQ2answers, "Vatikanstaten")

 */

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val button = findViewById<Button>(R.id.startButton)



        button.setOnClickListener {
            startCategoryQuestionActivity()
        }
/*
        val questions: Array<Question> = geographyCategory.questions

        questions.shuffle();

        var question = questions[0]

        question.answers.shuffle()

        var gButton1 = findViewById<Button>(R.id.gButton1)
        var gButton2 = findViewById<Button>(R.id.gButton2)
        var gButton3 = findViewById<Button>(R.id.gButton3)
        var gButton4 = findViewById<Button>(R.id.gButton4)




        gButton1.text = question.answers[0]
        gButton2.text = question.answers[1]
        gButton3.text = question.answers[2]
        gButton4.text = question.answers[3]

 */




    }




    fun startCategoryQuestionActivity() {

        // Log.e("!!!", "hej")

        val intent = Intent(this, CategoryQuestionActivity::class.java)
        startActivity(intent)

    }


}
