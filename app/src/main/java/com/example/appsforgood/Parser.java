package com.example.appsforgood;

import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.ArrayList;

public class Parser extends AppCompatActivity {

    static ArrayList<Question> questionList = new ArrayList<>();


    public ArrayList<Question> readQData() {

        InputStream is = getResources().openRawResource(R.raw.questions);
        BufferedReader reader = new BufferedReader(new InputStreamReader(is));

        String line = "";
        try {
            while ((line = reader.readLine()) != null) {

                //Split by ","
                String[] fields = line.split("~");

                questionList.add(new Question(fields[0], fields[1], fields[2], fields[3], fields[4]));

            }
        } catch (IOException io) {

            Log.wtf("MainActivity", "ERROR reading data on line " + line);
        }

        return questionList;

    }

    public ArrayList<Question> getQuestionList(){

        return questionList;
    }

}

