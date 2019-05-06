package com.example.appsforgood;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;

import static com.example.appsforgood.RepCollage.baker;

public class DifficultyPicker extends AppCompatActivity implements View.OnClickListener {

    static int i;
    static Button beginner;
    static Button intermediate;
    static Button expert;
    static Button insane;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_difficulty_picker);

        beginner = (Button) findViewById(R.id.beginnerButton);
        intermediate = (Button) findViewById(R.id.intermediateButton);
        expert = (Button) findViewById(R.id.expertButton);
        insane = (Button) findViewById(R.id.insaneButton);
        //stuff

        beginner.setOnClickListener(this);
        intermediate.setOnClickListener(this);
        expert.setOnClickListener(this);
        insane.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {

        switch (v.getId()) {
            case R.id.beginnerButton:
                i = 2;
                //Toast.makeText(getApplicationContext(), "Beginner is clicked " + Integer.toString(i), Toast.LENGTH_SHORT).show();
                break;
            case R.id.intermediateButton:
                i = 4;
                //Toast.makeText(getApplicationContext(), "Intermediate is clicked " + Integer.toString(i), Toast.LENGTH_SHORT).show();
                break;
            case R.id.expertButton:
                i = 7;
                //Toast.makeText(getApplicationContext(), "Expert is clicked " + Integer.toString(i), Toast.LENGTH_SHORT).show();
                break;
            case R.id.insaneButton:
                i = 9;
                //Toast.makeText(getApplicationContext(), "Insane is clicked " + Integer.toString(i), Toast.LENGTH_SHORT).show();
                break;
        }

        Intent intent = new Intent(this, QuizViewActivity.class);
        intent.putExtra("Score",i);
        startActivity(intent);
    }

    public void backButton(View v) {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

}
