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
    static ImageButton galvin;
    static ImageButton acosta;
    static ImageButton beaton;
    static ImageButton heffernan;
    static ImageButton kennealy;
    static ImageButton pollack;
    static ImageButton turco;
    static ImageButton tran;
    static ImageButton peyser;
    static ImageButton sudders;
    static ImageButton wood;
    static ImageButton moore;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rep_collage);

        //Ill probably use an arrayList for this later
        healey = (ImageButton) findViewById(R.id.healey);
        baker = (ImageButton) findViewById(R.id.baker);
        polito = (ImageButton) findViewById(R.id.polito);
        chandler = (ImageButton) findViewById(R.id.chandler);
        galvin = (ImageButton) findViewById(R.id.galvin);
        acosta = (ImageButton) findViewById(R.id.acosta);
        beaton = (ImageButton) findViewById(R.id.beaton);
        heffernan = (ImageButton) findViewById(R.id.heffernan);
        kennealy = (ImageButton) findViewById(R.id.kennealy);
        pollack = (ImageButton) findViewById(R.id.pollack);
        turco = (ImageButton) findViewById(R.id.turco);
        tran = (ImageButton) findViewById(R.id.tran);
        peyser = (ImageButton) findViewById(R.id.peyser);
        sudders = (ImageButton) findViewById(R.id.sudders);
        wood = (ImageButton) findViewById(R.id.wood);
        moore = (ImageButton) findViewById(R.id.moore);

        healey.setOnClickListener(this);
        baker.setOnClickListener(this);
        polito.setOnClickListener(this);
        chandler.setOnClickListener(this);
        galvin.setOnClickListener(this);
        acosta.setOnClickListener(this);
        beaton.setOnClickListener(this);
        heffernan.setOnClickListener(this);
        kennealy.setOnClickListener(this);
        pollack.setOnClickListener(this);
        turco.setOnClickListener(this);
        tran.setOnClickListener(this);
        peyser.setOnClickListener(this);
        sudders.setOnClickListener(this);
        wood.setOnClickListener(this);
        moore.setOnClickListener(this);

        }

        @Override
        public void onClick(View v) {

            switch (v.getId()) {
                case R.id.healey:
                    i = 0;
                    //Toast.makeText(getApplicationContext(), "Healey is clicked " + Integer.toString(i), Toast.LENGTH_SHORT).show();
                    break;
                case R.id.baker:
                    i = 1;
                    //Toast.makeText(getApplicationContext(), "Baker is clicked " + Integer.toString(i), Toast.LENGTH_SHORT).show();
                    break;
                case R.id.polito:
                    i = 2;
                    //Toast.makeText(getApplicationContext(), "Polito is clicked " + Integer.toString(i), Toast.LENGTH_SHORT).show();
                    break;
                case R.id.chandler:
                    i = 3;
                    //Toast.makeText(getApplicationContext(), "Chandler is clicked " + Integer.toString(i), Toast.LENGTH_SHORT).show();
                    break;
                 case R.id.galvin:
                    i = 4;
                    //Toast.makeText(getApplicationContext(), "Galvin is clicked " + Integer.toString(i), Toast.LENGTH_SHORT).show();
                    break;
                case R.id.acosta:
                    i = 5;
                    //Toast.makeText(getApplicationContext(), "Acosta is clicked " + Integer.toString(i), Toast.LENGTH_SHORT).show();
                    break;
                case R.id.beaton:
                    i = 6;
                  //Toast.makeText(getApplicationContext(), "Beaton is clicked " + Integer.toString(i), Toast.LENGTH_SHORT).show();
                    break;
                case R.id.heffernan:
                    i = 7;
                    //Toast.makeText(getApplicationContext(), "Heffernan is clicked " + Integer.toString(i), Toast.LENGTH_SHORT).show();
                    break;
                case R.id.kennealy:
                    i = 8;
                    //Toast.makeText(getApplicationContext(), "Kennealy is clicked " + Integer.toString(i), Toast.LENGTH_SHORT).show();
                    break;
             case R.id.pollack:
                   i = 9;
                    //Toast.makeText(getApplicationContext(), "Pollack is clicked " + Integer.toString(i), Toast.LENGTH_SHORT).show();
                 break;
              case R.id.turco:
                   i = 10;
                    //Toast.makeText(getApplicationContext(), "Turco is clicked " + Integer.toString(i), Toast.LENGTH_SHORT).show();
                   break;
              case R.id.tran:
                   i = 11;
                    //Toast.makeText(getApplicationContext(), "Tran is clicked " + Integer.toString(i), Toast.LENGTH_SHORT).show();
                    break;
                case R.id.peyser:
                    i = 12;
                    //Toast.makeText(getApplicationContext(), "Tran is clicked " + Integer.toString(i), Toast.LENGTH_SHORT).show();
                    break;
                case R.id.sudders:
                    i = 13;
                    //Toast.makeText(getApplicationContext(), "Tran is clicked " + Integer.toString(i), Toast.LENGTH_SHORT).show();
                    break;
                case R.id.wood:
                    i = 14;
                    //Toast.makeText(getApplicationContext(), "Tran is clicked " + Integer.toString(i), Toast.LENGTH_SHORT).show();
                    break;
                case R.id.moore:
                    i = 15;
                    //Toast.makeText(getApplicationContext(), "Tran is clicked " + Integer.toString(i), Toast.LENGTH_SHORT).show();
                    break;

            }

                Representatives.j = i;

                Intent intent = new Intent(this, Representatives.class);
                startActivity(intent);
            }

    public void backButton(View v) {
        Intent intent = new Intent(this, LearnActivity.class);
        startActivity(intent);
    }

}
