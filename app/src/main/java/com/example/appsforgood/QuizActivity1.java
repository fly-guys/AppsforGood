package com.example.appsforgood;

import android.content.Intent;
import android.os.CountDownTimer;
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
import java.util.Random;

public class QuizActivity1 extends AppCompatActivity {

    private ArrayList<Question> questionList = new ArrayList<>();
    static int i = 0;
    CountDownTimer timer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz1);
        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();

        boolean b;
        if(i > 0 && i < (questionList.size() - 1)) {
            b = bundle.getBoolean("Iterate");
        }
        else{
            b = true;
        }
        readQData(b);

        {
                timer = new CountDownTimer(16000, 1000){

                    TextView timerView = (TextView)findViewById(R.id.timerID);

                    public void onTick(long millisUntilFinished){
                        timerView.setText(String.valueOf(millisUntilFinished/1000));
                    }
                    public void onFinish(){
                        timerView.setText("0");
                            Log.d("timerTag","onFinishMethodOfTimer");
                            Intent i = new Intent(getApplicationContext(), Correct.class);
                            i.putExtra("Correct","Time's Up");
                            startActivity(i);
                    }

                }.start();


            //if(timerView.getText().equals("0")) {

        };
    }

    public void readQData(boolean b) {

        InputStream is = getResources().openRawResource(R.raw.questions);
        BufferedReader reader = new BufferedReader(new InputStreamReader(is));
        questionList.clear();
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

        questionMaker(questionList, b);


    }

    public void questionMaker(ArrayList<Question> questionList, boolean b){
        questionList.remove(i);
        i = (int) (Math.random()*(questionList.size()-1));
        TextView questionView = (TextView) findViewById(R.id.questionID);
        Button option1 = (Button) findViewById(R.id.option1ID);
        option1.setTag("Incorrect");
        Button option2 = (Button) findViewById(R.id.option2ID);
        option2.setTag("Incorrect");
        Button option3 = (Button) findViewById(R.id.option3ID);
        option3.setTag("Incorrect");
        Button option4 = (Button) findViewById(R.id.option4ID);
        option4.setTag("Incorrect");

        ArrayList<Button> buttons = new ArrayList<>();
        buttons.add(option1);
        buttons.add(option2);
        buttons.add(option3);
        buttons.add(option4);
        int correctButton = (int)(Math.random()*3);

        buttons.get(correctButton).setTag("Correct");

        while(b) {
            questionView.setText(questionList.get(i).getQuestion());
            buttons.get(correctButton).setText(questionList.get(i).getOption1());
            if (correctButton == 0) {
                buttons.get(1).setText(questionList.get(i).getOption2());
                buttons.get(3).setText(questionList.get(i).getOption3());
                buttons.get(2).setText(questionList.get(i).getOption4());

            } else if (correctButton == 1) {
                buttons.get(3).setText(questionList.get(i).getOption2());
                buttons.get(2).setText(questionList.get(i).getOption3());
                buttons.get(0).setText(questionList.get(i).getOption4());
            } else if (correctButton == 2) {
                buttons.get(0).setText(questionList.get(i).getOption2());
                buttons.get(1).setText(questionList.get(i).getOption3());
                buttons.get(3).setText(questionList.get(i).getOption4());
            } else if (correctButton == 3) {
                buttons.get(2).setText(questionList.get(i).getOption2());
                buttons.get(0).setText(questionList.get(i).getOption3());
                buttons.get(1).setText(questionList.get(i).getOption4());
            }

            i++;
            b = false;
        }
    }

    boolean isCounterRunning  = false;

    public void onClick(View v){

        timer.cancel();

        Button button1 = (Button)findViewById(R.id.option1ID);

        if(button1.getTag().equals("Correct")) {
            Intent intent = new Intent(this, Correct.class);
            intent.putExtra("Correct", "Correct");
            startActivity(intent);
        }
        else{
            Intent intent = new Intent(this, Correct.class);
            intent.putExtra("Correct", "Incorrect");
            startActivity(intent);
        }
    }

    public void onClick2(View v){

        timer.cancel();

        Button button2 = (Button)findViewById(R.id.option2ID);

        if(button2.getTag().equals("Correct")) {
            Intent intent = new Intent(this, Correct.class);
            intent.putExtra("Correct", "Correct");
            startActivity(intent);
        }
        else{
            Intent intent = new Intent(this, Correct.class);
            intent.putExtra("Correct", "Incorrect");
            startActivity(intent);
        }
    }

    public void onClick3(View v){

        timer.cancel();

        Button button3 = (Button)findViewById(R.id.option3ID);

        if(button3.getTag().equals("Correct")) {
            Intent intent = new Intent(this, Correct.class);
            intent.putExtra("Correct", "Correct");
            startActivity(intent);
        }
        else{
            Intent intent = new Intent(this, Correct.class);
            intent.putExtra("Correct", "Incorrect");
            startActivity(intent);
        }
    }

    public void onClick4(View v){

        timer.cancel();

        Button button4 = (Button)findViewById(R.id.option4ID);

        if(button4.getTag().equals("Correct")) {
            Intent intent = new Intent(this, Correct.class);
            intent.putExtra("Correct", "Correct");
            startActivity(intent);
        }
        else{
            Intent intent = new Intent(this, Correct.class);
            intent.putExtra("Correct", "Incorrect");
            startActivity(intent);
        }
    }


}
