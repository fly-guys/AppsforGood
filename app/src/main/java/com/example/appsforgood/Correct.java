package com.example.appsforgood;

import android.content.Intent;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Correct extends AppCompatActivity {

    static int score = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_correct);

        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();
        String answer = bundle.getString("Correct");

        TextView answerView = (TextView)findViewById(R.id.correctID);
        answerView.setText(answer);

        if(answerView.getText().equals("Correct")){
            score++;
        }

        TextView scoreView = (TextView)findViewById(R.id.scoreID);
        scoreView.setText(String.valueOf(score));

    }

    public void nextButton(View v){
        boolean b = true;
        Intent intent = new Intent(this,QuizActivity1.class);
        intent.putExtra("Iterate",b);
        intent.putExtra("Score",score);
        startActivity(intent);
    }

}
