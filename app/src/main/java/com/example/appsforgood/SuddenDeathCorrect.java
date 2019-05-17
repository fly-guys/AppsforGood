package com.example.appsforgood;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class SuddenDeathCorrect extends AppCompatActivity {

    /**
     * Sets the image to either the win or lose image depending on the results from SuddenDeathActivity
     * @param savedInstanceState the Instance State
     */
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

    /**
     *
     * @param v the View
     */
    public void backButton(View v){
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
