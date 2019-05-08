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

    public void goToCollage (View v){
        Intent intent = new Intent(this,RepCollage.class);
        intent.putExtra("Next","Next");
        startActivity(intent);
    }

    public void learnBillsButton (View v){
        Intent intent = new Intent(this,Bills.class);
        startActivity(intent);
    }

    public void backButton(View v) {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    public void legislativeBranch(View v){
        Intent intent = new Intent(this, LegislativeActivity.class);
        startActivity(intent);
    }
}
