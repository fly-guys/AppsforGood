package com.example.appsforgood;

import android.app.Application;
import android.util.Log;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class Controller extends Application {
    //Data
    private ArrayList<Question> questionList = new ArrayList<>();
    private ArrayList<RepObject> representatives = new ArrayList<>();
    int i;
    int j;

    @Override
    public void onCreate()  {
        super.onCreate();

        createQuestions();
        i = questionList.size();
        createReps();
        j = representatives.size();
    }

    /**
     * Populates an ArrayList of Question objects from a .csv file
     */
    public void createQuestions(){
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

        Collections.shuffle(questionList);
    }

    /**
     * Gets a Question object
     * @return a Question object
     */
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

    /**
     * Gets a Sudden Death Question object
     * @return a Question object
     */

    public Question getSuddenDeathQuestion(){
        i--;
        return questionList.get(i);
    }

    /**
     * Resets the Controller whenever a new Quiz is started
     */
    public void reset(){
        i = 0;
        onCreate();
    }

    /**
     * Parses the Representatives .csv file and creates an ArrayList with RepObject Objects
     */
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

    /**
     * Gets the next Representative from the ArrayList of RepObjects
     * @param next checks whether the user wants to go to the next Representative or the previous Representative. Loops to back of ArrayList if the user is at the end.
     * @return a RepObject
     */

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

