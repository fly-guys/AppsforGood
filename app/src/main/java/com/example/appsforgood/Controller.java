package com.example.appsforgood;

import android.app.Application;
import android.util.Log;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Controller extends Application {
    private ArrayList<Question> questionList = new ArrayList<>();
    private ArrayList<RepObject> representatives = new ArrayList<>();

    int i;
    int j;

    @Override
    public void onCreate()  {

        super.onCreate();

        InputStream is = getResources().openRawResource(R.raw.questions);
        BufferedReader reader = new BufferedReader(new InputStreamReader(is));

        String line = "";
        try {
            while ((line = reader.readLine()) != null) {

                //Split by ","
                String[] fields = line.split("~");

                questionList.add(new Question(fields[0], fields[1], fields[2], fields[3], fields[4], fields[5]));

            }
        } catch (IOException io) {

            Log.wtf("MainActivity", "ERROR reading data on line " + line);
        }
        int size = questionList.size();
        Question temp;
        int rand;
        for(int k = questionList.size() - 1; k > 0; k--){
            rand = (int)(Math.random()*size);
            temp = questionList.get(rand);
            questionList.set(rand,questionList.get(k));
            questionList.set(k,temp);
        }

        i = questionList.size();
        createReps();
        j = representatives.size();
    }

    public Question getQuestion(){
        i--;
        if(i > questionList.size() - 11) {
            return questionList.get(i);
        }
        else{
            Question nullQuestion = new Question("null","null","null","null","null","null");
            return nullQuestion;
        }
    }

    public void reset(){
        i = 0;
        onCreate();
    }

    public void createReps(){

        InputStream is = getResources().openRawResource(R.raw.profiles);
        BufferedReader reader = new BufferedReader(new InputStreamReader(is));

        String line = "";
        try {
            while ((line = reader.readLine()) != null) {

                //Split by ","
                String[] fields = line.split("~");

                representatives.add(new RepObject(fields[0], fields[1], fields[2], fields[3], fields[4], fields[5]));

            }
        } catch (IOException io) {

            Log.wtf("MainActivity", "ERROR reading data on line " + line);
        }



    }

    public RepObject getReps(String next){

        if(next.equals("Next")) {
            j--;
        }
        else{
            j++;
        }
        if(j >= 0) {
            return representatives.get(j);
        }
        else{
            j = representatives.size() - 1;
            return representatives.get(j);
        }
    }

}

