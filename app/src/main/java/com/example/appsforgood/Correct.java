package com.example.appsforgood;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class Correct extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_correct);

        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();
        String answer = bundle.getString("Correct");

        TextView answerView = (TextView)findViewById(R.id.correctID);
        answerView.setText(answer);
    }

    public void nextButton(View v){
        boolean b = true;
        Intent intent = new Intent(this,QuizActivity1.class);
        intent.putExtra("Iterate",b);
        startActivity(intent);
    }

}
