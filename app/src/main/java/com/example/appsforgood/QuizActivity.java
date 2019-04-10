package com.example.appsforgood;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Button;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class QuizActivity extends AppCompatActivity {


    private ArrayList<Question> questionList = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_questionview);

//        Intent intent = getIntent();
//
//        Parser parse = new Parser();
//
//        ArrayList<Question> questionList = parse.readQData();

//        imageView=(ImageView)findViewById(R.id.Spinner);

//        questionMaker(questionList);

//        TextView test = (TextView) findViewById(R.id.questionID);

        readQData();
    }


    public void readQData() {

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

        questionMaker(questionList);

    }

    public void questionMaker(ArrayList<Question> questionList){

        TextView questionView = (TextView) findViewById(R.id.questionID);
        Button option1 = (Button) findViewById(R.id.option1ID);
        option1.setTag("Correct");
        Button option2 = (Button) findViewById(R.id.option2ID);
        Button option3 = (Button) findViewById(R.id.option3ID);
        Button option4 = (Button) findViewById(R.id.option4ID);

        questionView.setText(questionList.get(1).getQuestion());
        option1.setText(questionList.get(1).getOption1());
        option2.setText(questionList.get(1).getOption2());
        option3.setText(questionList.get(1).getOption3());
        option4.setText(questionList.get(1).getOption4());

    }

    boolean clicked = false;

    public void onClick(View v) {
        Button option1 = (Button) findViewById(R.id.option1ID);
    }
}
