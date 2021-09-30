package com.example.quizapp

import java.io.Serializable

open class Question
    (val question: String,
     val answers: Array<String>,
     val rightAnswer: String): Serializable

