package com.example.appsforgood;

import android.content.Intent;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Random;

public class QuizViewActivity extends AppCompatActivity {

    private Controller aController;
    static CountDownTimer timer;
    static int computerScore = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz_view);

        Intent intent = getIntent();

        Bundle bundle = intent.getExtras();
        int playerScore = (Integer) bundle.getInt("Score");

        aController = (Controller) getApplicationContext();

        Question question = aController.getQuestion();

        if(question.getAnswer().equals("null")){
            Intent scoreIntent = new Intent(this, ScoreActivity.class);
            scoreIntent.putExtra("PlayerScore", playerScore);
            scoreIntent.putExtra("ComputerScore", computerScore);
            startActivity(scoreIntent);
        }
        else {
            TextView questionView = (TextView) findViewById(R.id.questionID);
            Button option1 = (Button) findViewById(R.id.option1ID);
            option1.setTag("Incorrect");


            Button option2 = (Button) findViewById(R.id.option2ID);

            option2.setTag("Incorrect");


            Button option3 = (Button) findViewById(R.id.option3ID);
            option3.setTag("Incorrect");


            Button option4 = (Button) findViewById(R.id.option4ID);
            option4.setTag("Incorrect");


            questionView.setText(question.getQuestion());

            ArrayList<Button> buttons = new ArrayList<>();
            buttons.add(option1);
            buttons.add(option2);
            buttons.add(option3);
            buttons.add(option4);

            Random randy = new Random();

            int correctButton = randy.nextInt(4);

            buttons.get(correctButton).setText(question.getAnswer());
            if (correctButton == 0) {
                buttons.get(1).setText(question.getChoice2());
                buttons.get(3).setText(question.getChoice3());
                buttons.get(2).setText(question.getChoice4());

            } else if (correctButton == 1) {
                buttons.get(3).setText(question.getChoice2());
                buttons.get(2).setText(question.getChoice3());
                buttons.get(0).setText(question.getChoice4());
            } else if (correctButton == 2) {
                buttons.get(0).setText(question.getChoice2());
                buttons.get(1).setText(question.getChoice3());
                buttons.get(3).setText(question.getChoice4());
            } else if (correctButton == 3) {
                buttons.get(2).setText(question.getChoice2());
                buttons.get(0).setText(question.getChoice3());
                buttons.get(1).setText(question.getChoice4());
            }

            if (option1.getText().equals(question.getAnswer())) {
                option1.setTag("Correct");

            }

            if (option2.getText().equals(question.getAnswer())) {
                option2.setTag("Correct");

            }

            if (option3.getText().equals(question.getAnswer())) {
                option3.setTag("Correct");

            }

            if (option4.getText().equals(question.getAnswer())) {
                option4.setTag("Correct");

            }

            timer = new CountDownTimer(16000, 1000) {

                TextView timerView = (TextView) findViewById(R.id.timerID);

                public void onTick(long millisUntilFinished) {
                    timerView.setText(String.valueOf(millisUntilFinished / 1000));
                    Log.d("Timer", String.valueOf(millisUntilFinished / 1000));
                }

                public void onFinish() {
                    timerView.setText("0");
                    Log.d("timerTag", "onFinishMethodOfTimer");
                    Intent i = new Intent(getApplicationContext(), Correct.class);
                    i.putExtra("Correct", "Time's Up");
                    startActivity(i);
                }
            }.start();
        }
    }

    public void onClick(View v){
        Button button = (Button)findViewById(v.getId());
        Random randy = new Random();
        if(randy.nextInt(4) < 3){
            computerScore++;
        }

        Log.d("Button ID--->>>", String.valueOf(v.getId()));
        Log.d("Button Text--->>>", String.valueOf(button.getText()));
        if(button.getTag().equals("Correct")) {
            Intent intent = new Intent(this, Correct.class);
            intent.putExtra("Correct", "Correct");
            intent.putExtra("ComputerScore",computerScore);
            timer.cancel();
            startActivity(intent);
        }
        else{
            Intent intent = new Intent(this, Correct.class);
            intent.putExtra("Correct", "Incorrect");
            intent.putExtra("ComputerScore",computerScore);
            timer.cancel();
            startActivity(intent);
        }
    }

    public void onDestroy(){
        super.onDestroy();
    }
}