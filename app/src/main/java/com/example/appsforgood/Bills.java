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

    public void backButton(View v) {

        Intent intent = new Intent(this, LearnActivity.class);
        startActivity(intent);

    }
    public void onClickGeneralLaws(View v) {
        Intent intent = new Intent();
        intent.setAction(Intent.ACTION_VIEW);
        intent.addCategory(Intent.CATEGORY_BROWSABLE);
        intent.setData(Uri.parse("https://malegislature.gov/Laws/GeneralLaws"));
        startActivity(intent);
    }
    public void onClickSessionsLaws(View v) {
        Intent intent = new Intent();
        intent.setAction(Intent.ACTION_VIEW);
        intent.addCategory(Intent.CATEGORY_BROWSABLE);
        intent.setData(Uri.parse("https://malegislature.gov/Laws/SessionLaws"));
        startActivity(intent);
    }
    public void onClickConstitution(View v) {
        Intent intent = new Intent();
        intent.setAction(Intent.ACTION_VIEW);
        intent.addCategory(Intent.CATEGORY_BROWSABLE);
        intent.setData(Uri.parse("https://malegislature.gov/Laws/SessionLaws"));
        startActivity(intent);
    }
}
