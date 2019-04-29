package com.example.appsforgood;

import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class RepresentativeParser extends AppCompatActivity {

    static ArrayList<RepObject> repList = new ArrayList<>();

    public ArrayList<RepObject> readRData() {

        InputStream is = getResources().openRawResource(R.raw.profiles);
        BufferedReader reader = new BufferedReader(new InputStreamReader(is));

        String line = "";
        try {
            while ((line = reader.readLine()) != null) {

                //Split by ","
                String[] fields = line.split("~");

                repList.add(new RepObject(fields[0], fields[1], fields[2], fields[3],fields[4],fields[5]));

            }
        } catch (IOException io) {

            Log.wtf("MainActivity", "ERROR reading data on line " + line);
        }

        return repList;

    }

    public ArrayList<RepObject> getRepList(){

        return repList;
    }

}
