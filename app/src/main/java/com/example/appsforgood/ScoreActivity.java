package com.example.appsforgood;

import android.content.Intent;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class ScoreActivity extends AppCompatActivity {
    //Data
    static CountDownTimer timer;

    /**
     * Compares the player score to the computer score at the end of the game, determines the winner, and displays the correct image
     * @param savedInstanceState the Instance State
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_score);

        QuizViewActivity quiz = new QuizViewActivity();

        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();

        final int score = (int) bundle.getInt("PlayerScore");
        final int computerScore = (int) bundle.getInt("ComputerScore");

        TextView computerScoreText = (TextView) findViewById(R.id.computerScore);
        computerScoreText.setText("" + computerScore);
        TextView playerScoreText = (TextView) findViewById(R.id.playerScore);
        playerScoreText.setText("" + score);

        ImageView winner = (ImageView) findViewById(R.id.winImageID);

        if(score > computerScore){
            winner.setImageResource(getResources().getIdentifier("@drawable/win", null, this.getPackageName()));;
            TextView timerView = (TextView) findViewById(R.id.timerID);
            timerView.setVisibility(View.GONE);
        }
        if(score < computerScore){
            TextView timerView = (TextView) findViewById(R.id.timerID);
            timerView.setVisibility(View.GONE);
        }
        else if (score == computerScore){
            winner.setImageResource(getResources().getIdentifier("@drawable/tie",null,this.getPackageName()));

            Button suddenDeath = (Button) findViewById(R.id.backButton);
            suddenDeath.setVisibility(View.GONE);

            timer = new CountDownTimer(6000, 1000) {

                TextView timerView = (TextView) findViewById(R.id.timerID);

                public void onTick(long millisUntilFinished) {
                    timerView.setText(String.valueOf(millisUntilFinished / 1000));
                    Log.d("Timer", String.valueOf(millisUntilFinished / 1000));
                }

                public void onFinish() {
                    timerView.setText("0");
                    Log.d("timerTag", "onFinishMethodOfTimer");
                    Intent i = new Intent(getApplicationContext(), SuddenDeathActivity.class);
                    i.putExtra("Computer Score",computerScore);
                    i.putExtra("Player Score",score);
                    onStop();
                    startActivity(i);
                }
            }.start();
        }
    }

    /**
     * Starts the Main Activity
     * @param v the View
     */
    public void onClick(View v){
        Intent intent = new Intent(this,MainActivity.class);
        startActivity(intent);

    }

    /**
     * Disables the back button on the Android device
     */
    @Override
    public void onBackPressed(){

    }
}
