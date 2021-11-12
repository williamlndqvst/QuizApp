package com.example.quizapp

open class Score {
    companion object {
        var correctAnswers: Int = 0
        var scorePoints: Int = 0
        var answeredCategories = mutableListOf<String>()

        var playerName : String = ""

    }
}
