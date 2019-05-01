package com.example.appsforgood;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class ScoreActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_score);

        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();

        int score = (int) bundle.getInt("PlayerScore");
        int computerScore = (int) bundle.getInt("ComputerScore");

        TextView computerScoreText = (TextView) findViewById(R.id.computerScore);
        computerScoreText.setText("" + computerScore);
        TextView playerScoreText = (TextView) findViewById(R.id.playerScore);
        playerScoreText.setText("" + score);

        ImageView winner = (ImageView) findViewById(R.id.winImageID);

        if(score > computerScore){
            winner.setImageResource(getResources().getIdentifier("@drawable/win", null, this.getPackageName()));;
        }

    }

    public void onClick(View v){
        Intent intent = new Intent(this,MainActivity.class);
        startActivity(intent);

    }
}
