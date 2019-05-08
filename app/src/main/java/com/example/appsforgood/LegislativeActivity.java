package com.example.appsforgood;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class LegislativeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_legislative);


    }

    public void backButton(View v){
        Intent intent = new Intent(this,LearnActivity.class);
        startActivity(intent);
    }

    public void houseButton(View v){
        Intent intent = new Intent();
        intent.setAction(Intent.ACTION_VIEW);
        intent.addCategory(Intent.CATEGORY_BROWSABLE);
        intent.setData(Uri.parse("https://malegislature.gov/Legislators/Members/House"));
        startActivity(intent);
    }

    public void senateButton(View v){
        Intent intent = new Intent();
        intent.setAction(Intent.ACTION_VIEW);
        intent.addCategory(Intent.CATEGORY_BROWSABLE);
        intent.setData(Uri.parse("https://malegislature.gov/Legislators/Members/Senate"));
        startActivity(intent);
    }
}
