package com.example.quizapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.room.Room
import kotlinx.coroutines.*
import kotlin.coroutines.CoroutineContext

class RestartScreenActivity : AppCompatActivity(), CoroutineScope {

    private lateinit var db : AppDatabase
    private lateinit var  job: Job

    override val coroutineContext : CoroutineContext
        get() = Dispatchers.Main + job

    var scoreView: TextView? = null
    var finalTextView: TextView? = null
    var restartButton: Button? = null



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_restart_screen)

        job = Job()

        db = Room.databaseBuilder(applicationContext, AppDatabase::class.java, "score").fallbackToDestructiveMigration().build()

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

        var player = Player(0, Score.playerName, Score.scorePoints)


        saveItem(player)


    }

    fun startCategoryQuestionActivity() {
        val intent = Intent(this, CategoryQuestionActivity::class.java)
        startActivity(intent)
    }

    override fun onDestroy(){
        job.cancel()
        super.onDestroy()
    }

    fun saveItem(item: Player){
        launch(Dispatchers.IO){
            db.playerDao().insert(item)

        }
    }

    fun loadAllItems() : Deferred<List<Player>> =
        async(Dispatchers.IO) {
            db.playerDao().getAll()
        }
}