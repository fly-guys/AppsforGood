package com.example.appsforgood;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;

public class DifficultyPicker extends AppCompatActivity implements View.OnClickListener {

    //Data
    static int i;
    static Button beginner;
    static Button intermediate;
    static Button expert;
    static Button insane;


    public static void refresh() {
    }

    /**
     * Sets up onClickListeners for difficulty button selectors
     * @param savedInstanceState the previous InstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_difficulty_picker);

        beginner = (Button) findViewById(R.id.beginnerButton);
        intermediate = (Button) findViewById(R.id.intermediateButton);
        expert = (Button) findViewById(R.id.expertButton);
        insane = (Button) findViewById(R.id.insaneButton);

        beginner.setOnClickListener(this);
        intermediate.setOnClickListener(this);
        expert.setOnClickListener(this);
        insane.setOnClickListener(this);
    }

    /**
     * Sets the difficulty for each button and begins the QuizViewActivity
     * @param v the View
     */
    @Override
    public void onClick(View v) {

        switch (v.getId()) {
            case R.id.beginnerButton:
                i = 2;
                break;
            case R.id.intermediateButton:
                i = 4;
                break;
            case R.id.expertButton:
                i = 7;
                break;
            case R.id.insaneButton:
                i = 9;
                break;
        }

        Intent intent = new Intent(this, QuizViewActivity.class);
        intent.putExtra("Score",0);
        intent.putExtra("New Game","New Game");
        startActivity(intent);
    }

    /**
     * onClick method that allows users to go back to the home page
     * @param v the View
     */
    public void backButton(View v) {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }


}
