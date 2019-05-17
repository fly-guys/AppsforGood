package com.example.appsforgood;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    /**
     * Starts the Main Activity
     * @param savedInstanceState the Instance State
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /**
     * onClick method that starts the Difficulty Picker Activity
     * @param v the View
     */
    public void playButton(View v){
        Intent intent = new Intent(this,DifficultyPicker.class);
        intent.putExtra("Score",4);
        startActivity(intent);
    }

    /**
     * onClick method that starts the Learn Activity
     * @param v the View
     */
    public void learnButton(View v){
        Intent intent = new Intent(this,LearnActivity.class);
        startActivity(intent);
    }

    /**
     * onClick method that starts the Instructions Activity
     * @param v the View
     */
    public void instructionsButton(View v){
        Intent intent = new Intent(this,InstructionsActivity.class);
        startActivity(intent);

    }


}

