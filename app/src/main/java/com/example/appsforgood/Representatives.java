package com.example.appsforgood;

import android.content.Intent;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Random;

import static com.example.appsforgood.RepresentativeParser.repList;

public class Representatives extends AppCompatActivity {

    private ArrayList<RepObject> repList = new ArrayList<>();
    static int j = RepCollage.i;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_representatives);
        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();
        boolean b;
        if (j > 0 && j < (repList.size() - 1)) {
            b = bundle.getBoolean("Iterate");
        } else {
            b = true;
        }
        readRData(b);
    }

    public void readRData(boolean b) {
        InputStream is = getResources().openRawResource(R.raw.profiles);
        BufferedReader reader = new BufferedReader(new InputStreamReader(is));
        repList.clear();
        String line = "";
        try {
            while ((line = reader.readLine()) != null) {

                //Split by ","
                String[] fields = line.split("~");

                repList.add(new RepObject(fields[0], fields[1], fields[2], fields[3], fields[4], fields[5]));

            }
        } catch (IOException io) {

            Log.wtf("MainActivity", "ERROR reading data on line " + line);
        }
        repMaker(repList, b);
    }

    public void repMaker(ArrayList<RepObject> repList, boolean b) {
        //j = RepCollage.i;
        //repList.remove(i);

        while(b) {
            TextView rep = (TextView) findViewById(R.id.repName);
            TextView pos = (TextView) findViewById(R.id.position);
            TextView part = (TextView) findViewById(R.id.party);
            TextView years = (TextView) findViewById(R.id.yearsInOffice);
            TextView descript = (TextView) findViewById(R.id.description);
            ImageView image = (ImageView) findViewById(R.id.repImage);

            rep.setText(repList.get(j).getrepName());
            pos.setText(repList.get(j).getposition());
            part.setText("Party: " + repList.get(j).getparty());
            years.setText("Years in Office: " + repList.get(j).getyearsInOffice());
            descript.setText(repList.get(j).getDescription());
            image.setImageResource(getResources().getIdentifier("@drawable/" + repList.get(j).getImage(), null, this.getPackageName()));
            //Toast.makeText(getApplicationContext(), Integer.toString(j), Toast.LENGTH_SHORT).show();
            //i++;
            b = false;
        }
    }

    public void previousRep(View v) {
      if (j == 0) {
          j = repList.size() - 1;
      }
      else {
          j--;
      }
        Intent intent = new Intent(this, Representatives.class);
        startActivity(intent);
    }

    public void nextRep (View v){
          if (j == repList.size()-1) {
              j = 0;
          }
          else {
              j++;
          }
            Intent intent = new Intent(this, Representatives.class);
            startActivity(intent);
    }

    public void toCollage (View v){
            Intent intent = new Intent(this, RepCollage.class);
            startActivity(intent);
    }

}
