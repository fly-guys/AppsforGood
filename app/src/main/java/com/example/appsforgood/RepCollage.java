package com.example.appsforgood;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;

public class RepCollage extends AppCompatActivity implements View.OnClickListener {
    static int i;
    static ImageButton healey;
    static ImageButton baker;
    static ImageButton polito;
    static ImageButton chandler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rep_collage);

        healey = (ImageButton) findViewById(R.id.healey);
        baker = (ImageButton) findViewById(R.id.baker);
        polito = (ImageButton) findViewById(R.id.polito);
        chandler = (ImageButton) findViewById(R.id.chandler);

        healey.setOnClickListener(this);
        baker.setOnClickListener(this);
        polito.setOnClickListener(this);
        chandler.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {

            switch (v.getId()) {
                case R.id.healey:
                    i = 0;
                    Toast.makeText(getApplicationContext(), "Healey is clicked " + Integer.toString(i), Toast.LENGTH_SHORT).show();
                    break;
                case R.id.baker:
                    i = 1;
                    Toast.makeText(getApplicationContext(), "Baker is clicked " + Integer.toString(i), Toast.LENGTH_SHORT).show();
                    break;
                case R.id.polito:
                    i = 2;
                    Toast.makeText(getApplicationContext(), "Polito is clicked " + Integer.toString(i), Toast.LENGTH_SHORT).show();
                    break;
                case R.id.chandler:
                    i = 3;
                    Toast.makeText(getApplicationContext(), "Chandler is clicked " + Integer.toString(i), Toast.LENGTH_SHORT).show();
                    break;
            }

            /*if(clicked){
                i=0;
                Toast.makeText(getApplicationContext(), "Healey is clicked" + Integer.toString(i), Toast.LENGTH_SHORT).show();
            }

            else if(clicked2){
                i=1;
                Toast.makeText(getApplicationContext(), "Baker is clicked" + Integer.toString(i), Toast.LENGTH_SHORT).show();
            }

            else if(clicked3){
                i=2;
                Toast.makeText(getApplicationContext(), "Polito is clicked" + Integer.toString(i), Toast.LENGTH_SHORT).show();
            }

            else if(clicked4) {
                i=3;
                Toast.makeText(getApplicationContext(), "Chandler is clicked" + Integer.toString(i), Toast.LENGTH_SHORT).show();
            }*/

            Representatives.j = i;

            Intent intent = new Intent(this, Representatives.class);
            startActivity(intent);
        }

    public void backButton(View v) {
        Intent intent = new Intent(this, LearnActivity.class);
        startActivity(intent);

    }

}
