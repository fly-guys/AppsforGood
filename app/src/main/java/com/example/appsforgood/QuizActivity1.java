package com.example.appsforgood;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class QuizActivity1 extends AppCompatActivity {

    private ArrayList<Question> questionList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz1);

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
        option2.setTag("Incorrect");
        Button option3 = (Button) findViewById(R.id.option3ID);
        option3.setTag("Incorrect");
        Button option4 = (Button) findViewById(R.id.option4ID);
        option4.setTag("Incorrect");

        questionView.setText(questionList.get(1).getQuestion());
        option1.setText(questionList.get(1).getOption1());
        option2.setText(questionList.get(1).getOption2());
        option3.setText(questionList.get(1).getOption3());
        option4.setText(questionList.get(1).getOption4());

    }

    boolean clicked = false;


    public void onClick(View v){
        Button button1 = (Button)findViewById(R.id.option1ID);

        if(button1.getTag().equals("Correct")) {
            Intent intent = new Intent(this, Correct.class);
            intent.putExtra("Correct", "correct");
            startActivity(intent);
        }
        else{
            Intent intent = new Intent(this, Correct.class);
            intent.putExtra("Correct", "incorrect");
            startActivity(intent);
        }
    }

    public void onClick2(View v){
        Button button2 = (Button)findViewById(R.id.option2ID);

        if(button2.getTag().equals("Correct")) {
            Intent intent = new Intent(this, Correct.class);
            intent.putExtra("Correct", "correct");
            startActivity(intent);
        }
        else{
            Intent intent = new Intent(this, Correct.class);
            intent.putExtra("Correct", "incorrect");
            startActivity(intent);
        }
    }

    public void onClick3(View v){
        Button button3 = (Button)findViewById(R.id.option3ID);

        if(button3.getTag().equals("Correct")) {
            Intent intent = new Intent(this, Correct.class);
            intent.putExtra("Correct", "correct");
            startActivity(intent);
        }
        else{
            Intent intent = new Intent(this, Correct.class);
            intent.putExtra("Correct", "incorrect");
            startActivity(intent);
        }
    }

    public void onClick4(View v){
        Button button4 = (Button)findViewById(R.id.option4ID);

        if(button4.getTag().equals("Correct")) {
            Intent intent = new Intent(this, Correct.class);
            intent.putExtra("Correct", "correct");
            startActivity(intent);
        }
        else{
            Intent intent = new Intent(this, Correct.class);
            intent.putExtra("Correct", "incorrect");
            startActivity(intent);
        }
    }
}
