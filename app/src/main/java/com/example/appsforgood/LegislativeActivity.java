package com.example.appsforgood;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class LegislativeActivity extends AppCompatActivity {

    /**
     * Starts the Legislative Activity
     * @param savedInstanceState the InstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_legislative);
    }

    /**
     * onClick method that starts the Learn Activity
     * @param v the View
     */
    public void backButton(View v){
        Intent intent = new Intent(this,LearnActivity.class);
        startActivity(intent);
    }

    /**
     * onClick method that redirects the app to the mass.gov website representatives page
     * @param v the View
     */
    public void houseButton(View v){
        Intent intent = new Intent();
        intent.setAction(Intent.ACTION_VIEW);
        intent.addCategory(Intent.CATEGORY_BROWSABLE);
        intent.setData(Uri.parse("https://malegislature.gov/Legislators/Members/House"));
        startActivity(intent);
    }

    /**
     * onClick method that redirects the app to the mass.gov website senate page
     * @param v
     */
    public void senateButton(View v){
        Intent intent = new Intent();
        intent.setAction(Intent.ACTION_VIEW);
        intent.addCategory(Intent.CATEGORY_BROWSABLE);
        intent.setData(Uri.parse("https://malegislature.gov/Legislators/Members/Senate"));
        startActivity(intent);
    }

    /**
     * Disables the back button on the Android device
     */
    @Override
    public void onBackPressed(){

    }
}
