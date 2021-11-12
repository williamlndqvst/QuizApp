package com.example.quizapp

import android.graphics.Color
import androidx.room.Entity
import java.io.Serializable

@Entity
open class Category: Serializable {
    var name: String = ""
    var questions: Array<Question> = emptyArray();
    var color : Int = R.color.white

}




