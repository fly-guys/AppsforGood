package com.example.appsforgood;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class SuddenDeathCorrect extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sudden_death_correct);

        Intent intent = getIntent();

        Bundle bundle = intent.getExtras();

        String correct = bundle.getString("Correct");
        ImageView imageView = (ImageView) findViewById(R.id.winOrLose);

        if(!correct.equals("Correct")){
            imageView.setImageResource(getResources().getIdentifier("@drawable/lose", null, this.getPackageName()));
        }
    }

    public void backButton(View v){
        Intent intent = new Intent(this,MainActivity.class);
        startActivity(intent);
    }

    @Override
    public void onBackPressed(){

    }
}
