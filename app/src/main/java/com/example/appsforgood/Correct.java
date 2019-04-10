package com.example.appsforgood;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.TextView;

public class Correct extends AppCompatActivity {

    private final String TAG = "In MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_correctview);


        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();
        String correct = bundle.getString("Correct");

        TextView answerView = (TextView)findViewById(R.id.correctID);
        answerView.setText(correct);

        Log.d(TAG,correct);
        String stupid = "stupid";


//        imageView=(ImageView)findViewById(R.id.Spinner);


    }
}
