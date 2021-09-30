package com.example.quizapp

import android.graphics.Color
import java.io.Serializable

open class Category: Serializable {
    var name: String = ""
    var questions: Array<Question> = emptyArray();
    var color : Int = R.color.white
        //Color.parseColor(Category.color!!)

}




