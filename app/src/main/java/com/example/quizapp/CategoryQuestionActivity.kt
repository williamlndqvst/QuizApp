package com.example.quizapp

import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import java.io.Serializable

class CategoryQuestionActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_category_question)

        val geographyButton = findViewById<Button>(R.id.geographyButton)


        geographyButton.setOnClickListener {
            startGeographyQuestionActivity()
        }
        val historyButton = findViewById<Button>(R.id.historyButton)

        historyButton.setOnClickListener {
            startHistoryQuestionActivity()
        }
        val sportButton = findViewById<Button>(R.id.sportButton)

        sportButton.setOnClickListener {
            startSportQuestionActivity()
        }
        val technologyButton = findViewById<Button>(R.id.technologyButton)

        technologyButton.setOnClickListener {
            startTechnologyQuestionActivity()
        }


    }
        fun startGeographyQuestionActivity() {


            var gQ1answers: Array<String> = arrayOf("Kina", "Ryssland", "USA", "Indien")
            val gQ1 = Question("Vilket är världens största land sett till yta?", gQ1answers, "Ryssland" )

            var gQ2answers: Array<String> = arrayOf("Monaco", "Liechtenstein", "Vatikanstaten", "San Marino")
            val gQ2 = Question("Vilket är världens minsta land sett till yta?", gQ2answers, "Vatikanstaten")

            var gQ3answers: Array<String> = arrayOf("Valletta", "Vilnius", "Pristina", "Vaduz")
            val gQ3 = Question("Vad heter Maltas huvudstad?", gQ3answers, "Valletta")

            var gQ4answers: Array<String> = arrayOf("Nilen", "Donau", "Mississippi", "Ganges")
            val gQ4 = Question("Vad heter världens längsta flod?", gQ4answers, "Nilen")

            var gQ5answers: Array<String> = arrayOf("Nederländska", "Franska", "Engelska", "Spanska")
            val gQ5 = Question("Vilket är det officiella språket i Surinam?", gQ5answers, "Nederländska")

            var gQ6answers: Array<String> = arrayOf("Nya Zeeland", "Australien", "Sydafrika", "Kroatien")
            val gQ6 = Question("I vilket land är Sagan om Ringen-filmerna inspelade?", gQ6answers, "Nya Zeeland")

            var gQ7answers: Array<String> = arrayOf("Alaska", "Texas", "Kalifornien", "Montana")
            val gQ7 = Question("Vilket är USA:s till ytan största delstat?", gQ7answers, "Alaska")

            var gQ8answers: Array<String> = arrayOf("Kroatien", "Cypern", "Malta", "Andorra")
            val gQ8 = Question("Världens till befolkningen minsta stad heter Hum, och ligger i vilket europeiskt land?", gQ8answers, "Kroatien")

            var gQ9answers: Array<String> = arrayOf("Skåne", "Blekinge", "Medelpad", "Lappland")
            val gQ9 = Question("Vilket är Sveriges största landskap?", gQ9answers, "Lappland")

            var geographyQuestions: Array<Question> = arrayOf(gQ1, gQ2, gQ3, gQ4, gQ5, gQ6, gQ7, gQ8,gQ9)
            val geographyCategory: Category = Category();
            geographyCategory.name = "Geography"
            geographyCategory.questions = geographyQuestions;
            geographyCategory.color = R.color.green


            val intent = Intent(this, QuestionsActivity::class.java)
            intent.putExtra("category", geographyCategory);
            startActivity(intent)


            /*
            val intent = Intent(this, GeographyQuestionActivity::class.java)
            startActivity(intent)
            */

        }

        fun startHistoryQuestionActivity() {
            var hQ1answers: Array<String> = arrayOf("Thomas Jefferson", "George Washington", "Abraham Lincoln", "Theodore Roosevelt")
            val hQ1 = Question("Vad heter USA:s första president?", hQ1answers, "George Washington")

            var hQ2answers: Array<String> = arrayOf("1944", "1946", "1945", "1943")
            val hQ2 = Question("Vilket år slutade det andra världskriget?", hQ2answers, "1945")

            var hQ3answers: Array<String> = arrayOf("Vulkanutbrott", "Jordbävning", "Tsunami", "Översvämmning")
            val hQ3 = Question("Vilken händelse på Island stoppade fkygtrafiken i nästan hela Nordeuropa i april 2010?", hQ3answers, "Vulkanutbrott")

            var hQ4answers: Array<String> = arrayOf("Augustus", "Nero", "Tiberius", "Caligula")
            val hQ4 = Question("Vem var den första romerska kejsaren?", hQ4answers, "Augustus")

            var historyQuestions: Array<Question> = arrayOf(hQ1, hQ2, hQ3, hQ4)
            val historyCategory: Category = Category();
            historyCategory.name = "History"
            historyCategory.questions = historyQuestions;
            historyCategory.color = R.color.red

            val intent = Intent(this, QuestionsActivity::class.java)
            intent.putExtra("category", historyCategory);
            startActivity(intent)



    }
        fun startSportQuestionActivity() {
            var sQ1answers: Array<String> = arrayOf("Spanien", "Brasilien", "Frankrike", "Tyskland")
            val sQ1 = Question("Vilket land vann VM i fotboll år 2010?", sQ1answers, "Spanien")

            var sQ2answers: Array<String> = arrayOf("Italien", "Brasilien", "Storbritannien", "Österrike")
            val sQ2 = Question("Vilket land kom Formel 1 legenden Ayrton Senna ifrån?", sQ2answers, "Brasilien")

            var sportQuestions: Array<Question> = arrayOf(sQ1, sQ2)
            val sportCategory: Category = Category();
            sportCategory.name = "Sport"
            sportCategory.questions = sportQuestions;
            sportCategory.color = R.color.orange


            val intent = Intent(this, QuestionsActivity::class.java)
            intent.putExtra("category", sportCategory);
            startActivity(intent)




    }
        fun startTechnologyQuestionActivity() {
            var tQ1answers: Array<String> = arrayOf("2007", "2009", "2006", "2008")
            val tQ1 = Question("Vilket år lanserade Apple deras första iPhone?", tQ1answers, "2007")

            var tQ2answers: Array<String> = arrayOf("SpaceX", "Blue Origin", "NASA", "Stratolaunch Systems")
            val tQ2 = Question("Vad heter Elon Musks rymdföretag?", tQ2answers, "SpaceX")

            var technologyQuestions: Array<Question> = arrayOf(tQ1, tQ2)
            val technologyCategory: Category = Category()

            technologyCategory.name = "Technology"
            technologyCategory.questions = technologyQuestions;
            technologyCategory.color = R.color.blue


            val intent = Intent(this, QuestionsActivity::class.java)
            intent.putExtra("category", technologyCategory);
            startActivity(intent)

        }




}