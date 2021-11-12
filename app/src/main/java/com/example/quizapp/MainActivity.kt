package com.example.quizapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.core.widget.addTextChangedListener
import androidx.room.Room
import kotlinx.coroutines.*
import kotlin.coroutines.CoroutineContext

 class MainActivity : AppCompatActivity(), CoroutineScope {

    private lateinit var db : AppDatabase
     private lateinit var  job: Job


     override val coroutineContext: CoroutineContext
        get() = Dispatchers.Main + job


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        db = Room.databaseBuilder(applicationContext, AppDatabase::class.java, "score").fallbackToDestructiveMigration().allowMainThreadQueries().build()

        job = Job()


        var highscores = db.playerDao().getAll()

        var inputName = findViewById<EditText>(R.id.playerNameText)
        var playerName = inputName.text
        var highScoreText = findViewById<TextView>(R.id.highscoreTextView)
        var text = ""

        for((index, player) in highscores.withIndex()){
            text += "" + (index + 1) + ", Name: " +  player.name + " -- Score: " + player.score + "\n" + "\n"
        }

        highScoreText.setText(text)
        db.playerDao().getAll()
        loadAllItems()



        val button = findViewById<Button>(R.id.startButton)
        button.setOnClickListener {
            Score.playerName = playerName.toString()
            startCategoryQuestionActivity()
        }

        inputName.addTextChangedListener {
            button!!.setBackgroundColor(ContextCompat.getColor(this, R.color.purple_200))
            button.isClickable = true
        }

        if(inputName.text.isNotEmpty()) {
            Score.playerName = playerName.toString()

        }

    }

    fun loadAllItems() : Deferred<List<Player>> =
        async(Dispatchers.IO) {
            db.playerDao().getAll()
        }

    private fun startCategoryQuestionActivity() {
        val intent = Intent(this, CategoryQuestionActivity::class.java)
        startActivity(intent)
    }

}
