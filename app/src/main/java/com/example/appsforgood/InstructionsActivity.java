package com.example.appsforgood;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class InstructionsActivity extends AppCompatActivity {

    /**
     * Starts the InstructionsActivity
     * @param savedInstanceState the savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_instructions);
    }

    /**
     * onClick method that brings the user back to the home screen
     * @param v
     */
    public void clickBack(View v){
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
