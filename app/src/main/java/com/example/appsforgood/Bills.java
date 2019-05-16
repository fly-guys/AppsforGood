package com.example.appsforgood;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class Bills extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bills);
    }

    /**
     * Starts an intent to go back to the LearnActivity class
     * @param v
     */
    public void backButton(View v) {
        Intent intent = new Intent(this, LearnActivity.class);
        startActivity(intent);
    }

    /**
     * Starts an intent to direct the user to the General Laws section of the mass.gov website
     * @param v
     */
    public void onClickGeneralLaws(View v) {
        Intent intent = new Intent();
        intent.setAction(Intent.ACTION_VIEW);
        intent.addCategory(Intent.CATEGORY_BROWSABLE);
        intent.setData(Uri.parse("https://malegislature.gov/Laws/GeneralLaws"));
        startActivity(intent);
    }

    /**
     * Starts an intent to direct the user to the Sessions Laws section of the mass.gov website
     * @param v
     */
    public void onClickSessionsLaws(View v) {
        Intent intent = new Intent();
        intent.setAction(Intent.ACTION_VIEW);
        intent.addCategory(Intent.CATEGORY_BROWSABLE);
        intent.setData(Uri.parse("https://malegislature.gov/Laws/SessionLaws"));
        startActivity(intent);
    }

    /**
     * Starts an intent to direct the user to the Massachusetts Constitution on the mass.gov website
     * @param v
     */
    public void onClickConstitution(View v) {
        Intent intent = new Intent();
        intent.setAction(Intent.ACTION_VIEW);
        intent.addCategory(Intent.CATEGORY_BROWSABLE);
        intent.setData(Uri.parse("https://malegislature.gov/Laws/SessionLaws"));
        startActivity(intent);
    }

    /**
     * Prevents the back button on the Android device from being used to go to the previous page
     */
    @Override
    public void onBackPressed(){

    }
}
