package com.example.appsforgood;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class Correct extends AppCompatActivity {


    static int score = 0;

    /**
     * Sets TextView to tell the user whether they got the correct answer. Sets TextView to tell the user what the correct answer was. Shows the user and computer scores.
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_correct);

        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();
        String answer = bundle.getString("Correct");
        int computerScore = bundle.getInt("ComputerScore");

        TextView answerView = (TextView)findViewById(R.id.correctID);
        answerView.setText(answer);

        if(answerView.getText().equals("Correct")){
            score++;
        }
        else{
            TextView correctAnswerView = (TextView) findViewById(R.id.correctAnswerID);
            correctAnswerView.setText("Correct Answer: " + bundle.getString("CorrectAnswer"));
        }

        TextView scoreView = (TextView)findViewById(R.id.scoreID);
        scoreView.setText(String.valueOf(score));
        TextView computerScoreView = (TextView) findViewById(R.id.computerScoreID);
        computerScoreView.setText(String.valueOf(computerScore));

    }

    /**
     * Goes to next question
     * @param v
     */
    public void nextButton(View v){
        Intent intent = new Intent(this,QuizViewActivity.class);
        intent.putExtra("Score",score);
        intent.putExtra("New Game","Same Game");
        startActivity(intent);
    }

    /**
     * Resets Correct page for each new quiz
     */
    public void reset(){
        score = 0;
    }

    /**
     * Disables tablet back button from working so users cannot try to reanswer questions
     */
    @Override
    public void onBackPressed(){

    }
}
