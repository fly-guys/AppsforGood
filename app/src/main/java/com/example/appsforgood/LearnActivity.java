package com.example.appsforgood;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class LearnActivity extends AppCompatActivity {

    /**
     * Starts the LearnActivity
     * @param savedInstanceState the InstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_learn);
    }

    /**
     * onClick method that starts the RepCollage activity
     * @param v the View
     */
    public void goToCollage (View v){
        Intent intent = new Intent(this,RepCollage.class);
        intent.putExtra("Next","Next");
        startActivity(intent);
    }

    /**
     * onClick method that starts the Bills activity
     * @param v
     */
    public void learnBillsButton (View v){
        Intent intent = new Intent(this,Bills.class);
        startActivity(intent);
    }

    /**
     * onClick method that brings the user back to the Home screen
     * @param v
     */
    public void backButton(View v) {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    /**
     * onClick method that starts the Legislative Activity
     * @param v
     */
    public void legislativeBranch(View v){
        Intent intent = new Intent(this, LegislativeActivity.class);
        startActivity(intent);
    }

    /**
     * Disables the back button on the Android device
     */
    @Override
    public void onBackPressed(){

    }
}
