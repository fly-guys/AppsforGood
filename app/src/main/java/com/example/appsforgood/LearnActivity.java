package com.example.appsforgood;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class LearnActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_learn);
    }

    public void learnRepsButton (View v){
        Intent intent = new Intent(this,Representatives.class);
        startActivity(intent);
    }

    public void learnBillsButton (View v){
        Intent intent = new Intent(this,Bills.class);
        startActivity(intent);
    }
}
