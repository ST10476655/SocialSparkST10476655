package za.ac.iie.socialspark

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import android.widget.Toast.makeText
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

private fun Button.setOnClickListner(function: () -> Unit) {}

class MainActivity : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)//Links this kotlin file to the xml layout (UI)

        val timeInput = findViewById<EditText>(R.id.timeInput)
        val resultText = findViewById<TextView>(R.id.resultText)
        val suggestButton = findViewById<Button>(R.id.suggestButton)
        val restButton = findViewById<Button>(R.id.resetButton) //line 24-27 connects var to the UI

        suggestButton.setOnClickListner { //Generates a SocialSpark suggestion
            val time = timeInput.text.toString().lowercase()

            if (time.isEmpty()) { //Suggestions for different times of the day

                Toast.makeText(this,
                    "Please enter a time of the day to get a spark",
                    Toast.LENGTH_LONG).show()

            } else if (time == "morning") {

                resultText.text =
                    "send a 'Good morning' text to a family member"

            } else if (time == "mid-morning") {

                resultText.text =
                    "Reach out to a colleague with a quick 'Thank you.'"

            } else if (time == "afternoon") {

                resultText.text =
                    "Share a funny meme of interesting link with a friend"

            } else if (time == "afternoon snack time") {

                resultText.text =
                    "Send a quick 'Thinking of you' message."

            } else if (time == "dinner") {

                resultText.text =
                    "Call a friend or ralative for a 5-minute catch-up"

            } else if (time == "after dinner" || time == "night") {

                resultText.text =
                    "Leave a thoughtful comment on a friend's post."

            } else { //Invalid input error massage
                resultText.text =
                    "Invalid Input. Try Morning, Afternoon, Dinner, or Night."
            }
        }

        restButton.setOnClickListner { //It clears both input and suggestion
            timeInput.text.clear() //clears input
            resultText.text = "" //clears suggestion
        }
    }
}