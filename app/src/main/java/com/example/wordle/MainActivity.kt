package com.example.wordle

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.google.android.material.textfield.TextInputLayout

class MainActivity : AppCompatActivity()
{
    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //Randomize four letter word list
        FourLetterWordList.getAllFourLetterWords()

        //Keep track of guesses
        var guesses = 0
        // The button being used as variable
        val guessButton = findViewById<Button>(R.id.button)

        // Get the answer of the wordle
        val answer = findViewById<TextView>(R.id.answer)
        var seek = answer.toString()
        seek = FourLetterWordList.getRandomFourLetterWord()
        answer.text = seek

        //function to check if the answer is correct
        fun checkGuess(guess: String) : String {
            var result = ""
            for (i in 0..3) {
                if (guess[i] == seek[i]) {
                    result += "O"
                }
                else if (guess[i] in seek) {
                    result += "+"
                }
                else {
                    result += "X"
                }
            }
            return result
        }




        guessButton.setOnClickListener {
            // Get the input from the input layout.
            val userInput = findViewById<EditText>(R.id.userinputbar)
            if(guesses == 0)
            {
                var guess1text  = findViewById<TextView>(R.id.userGuess1userinput)
                var guess1answer = findViewById<TextView>(R.id.userguess1answer)
                guess1text.text = userInput.text.toString()
                var toCheck1 = guess1text.text.toString().uppercase()
                var anwserone = checkGuess(toCheck1)
                guess1answer.text = anwserone
                guesses++
                if(guess1answer.text == "OOOO")
                {
                    var anwer = findViewById<TextView>(R.id.answer)
                    anwer.visibility = View.VISIBLE
                }
            }
            else if(guesses == 1)
            {
                var guess2text = findViewById<TextView>(R.id.userGuess2display)
                var guess2answer = findViewById<TextView>(R.id.userinput2answer)
                guess2text.text = userInput.text.toString()
                var tocheck2 = guess2text.text.toString().uppercase()
                var answer2 = checkGuess(tocheck2)
                guess2answer.text = answer2
                guesses++
                if(guess2answer.text == "OOOO")
                {
                    var anwer = findViewById<TextView>(R.id.answer)
                    anwer.visibility = View.VISIBLE
                }

            }
            else if(guesses == 2)
            {
                var guess3text = findViewById<TextView>(R.id.user3display)
                var guess3answer = findViewById<TextView>(R.id.user3answer)
                guess3text.text = userInput.text.toString()
                var toCheck3 = guess3text.text.toString().uppercase()
                var answer3 = checkGuess(toCheck3)
                guess3answer.text = answer3
                if(guess3answer.text == "OOOO")
                {
                    var anwer = findViewById<TextView>(R.id.answer)
                    anwer.visibility = View.VISIBLE
                    guessButton.visibility = View.INVISIBLE
                }
                else
                {
                    var anwer = findViewById<TextView>(R.id.answer)
                    anwer.visibility = View.VISIBLE
                    guessButton.visibility = View.INVISIBLE
                }
            }
        }

    }

    // author: calren
    object FourLetterWordList
    {
        // List of most common 4 letter words from: https://7esl.com/4-letter-words/
        val fourLetterWords =
            "Area,Army,Baby,Back,Ball,Band,Bank,Base,Bill,Body,Book,Call,Card,Care,Case,Cash,City,Club,Cost,Date,Deal,Door,Duty,East,Edge,Face,Fact,Farm,Fear,File,Film,Fire,Firm,Fish,Food,Foot,Form,Fund,Game,Girl,Goal,Gold,Hair,Half,Hall,Hand,Head,Help,Hill,Home,Hope,Hour,Idea,Jack,John,Kind,King,Lack,Lady,Land,Life,Line,List,Look,Lord,Loss,Love,Mark,Mary,Mind,Miss,Move,Name,Need,News,Note,Page,Pain,Pair,Park,Part,Past,Path,Paul,Plan,Play,Post,Race,Rain,Rate,Rest,Rise,Risk,Road,Rock,Role,Room,Rule,Sale,Seat,Shop,Show,Side,Sign,Site,Size,Skin,Sort,Star,Step,Task,Team,Term,Test,Text,Time,Tour,Town,Tree,Turn,Type,Unit,User,View,Wall,Week,West,Wife,Will,Wind,Wine,Wood,Word,Work,Year,Bear,Beat,Blow,Burn,Call,Care,Cast,Come,Cook,Cope,Cost,Dare,Deal,Deny,Draw,Drop,Earn,Face,Fail,Fall,Fear,Feel,Fill,Find,Form,Gain,Give,Grow,Hang,Hate,Have,Head,Hear,Help,Hide,Hold,Hope,Hurt,Join,Jump,Keep,Kill,Know,Land,Last,Lead,Lend,Lift,Like,Link,Live,Look,Lose,Love,Make,Mark,Meet,Mind,Miss,Move,Must,Name,Need,Note,Open,Pass,Pick,Plan,Play,Pray,Pull,Push,Read,Rely,Rest,Ride,Ring,Rise,Risk,Roll,Rule,Save,Seek,Seem,Sell,Send,Shed,Show,Shut,Sign,Sing,Slip,Sort,Stay,Step,Stop,Suit,Take,Talk,Tell,Tend,Test,Turn,Vary,View,Vote,Wait,Wake,Walk,Want,Warn,Wash,Wear,Will,Wish,Work,Able,Back,Bare,Bass,Blue,Bold,Busy,Calm,Cold,Cool,Damp,Dark,Dead,Deaf,Dear,Deep,Dual,Dull,Dumb,Easy,Evil,Fair,Fast,Fine,Firm,Flat,Fond,Foul,Free,Full,Glad,Good,Grey,Grim,Half,Hard,Head,High,Holy,Huge,Just,Keen,Kind,Last,Late,Lazy,Like,Live,Lone,Long,Loud,Main,Male,Mass,Mean,Mere,Mild,Nazi,Near,Neat,Next,Nice,Okay,Only,Open,Oral,Pale,Past,Pink,Poor,Pure,Rare,Real,Rear,Rich,Rude,Safe,Same,Sick,Slim,Slow,Soft,Sole,Sore,Sure,Tall,Then,Thin,Tidy,Tiny,Tory,Ugly,Vain,Vast,Very,Vice,Warm,Wary,Weak,Wide,Wild,Wise,Zero,Ably,Afar,Anew,Away,Back,Dead,Deep,Down,Duly,Easy,Else,Even,Ever,Fair,Fast,Flat,Full,Good,Half,Hard,Here,High,Home,Idly,Just,Late,Like,Live,Long,Loud,Much,Near,Nice,Okay,Once,Only,Over,Part,Past,Real,Slow,Solo,Soon,Sure,That,Then,This,Thus,Very,When,Wide"

        // Returns a list of four letter words as a list
        fun getAllFourLetterWords(): List<String>
        {
            return fourLetterWords.split(",")
        }

        // Returns a random four letter word from the list in all caps
        fun getRandomFourLetterWord(): String
        {
            val allWords = getAllFourLetterWords()
            val randomNumber = (0..allWords.size).shuffled().last()
            return allWords[randomNumber].uppercase()
        }
    }

}

