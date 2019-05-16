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
    DifficultyPicker difficultyPicker = new DifficultyPicker();
    String correctAnswer = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz_view);

        Intent intent = getIntent();

        aController = (Controller) getApplicationContext();
        Random randy = new Random();

        Bundle bundle = intent.getExtras();
        int playerScore = (Integer) bundle.getInt("Score");
        if(bundle.getString("New Game").equals("New Game")){
            computerScore = 0;
            Correct.score = 0;
            DifficultyPicker.refresh();
            aController.reset();
            //pushing reset code
        }

        Question question = aController.getQuestion();

        Log.d("Got Question","Got Question");
//        if(bundle.getString("New Game").equals("Sudden Death")){
//            Log.d("SuddenDeath-------->","Got to Sudden Death");
//            question = aController.getSuddenDeathQuestion();
//        }

        if(question.getAnswer().equals("null")){
//            if(playerScore == computerScore){
//               question = aController.getSuddenDeathQuestion();
//               displayQuestion(question);
//            }
            Intent scoreIntent = new Intent(this, ScoreActivity.class);
            scoreIntent.putExtra("PlayerScore", playerScore);
            scoreIntent.putExtra("ComputerScore", computerScore);
            finish();
            startActivity(scoreIntent);
        }
        else {
            displayQuestion(question);
        }
    }

    public void displayQuestion(Question question){
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

        final Random randy = new Random();

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
        correctAnswer = question.getAnswer();

        timer = new CountDownTimer(16000, 1000) {

            TextView timerView = (TextView) findViewById(R.id.timerID);

            public void onTick(long millisUntilFinished) {
                timerView.setText(String.valueOf(millisUntilFinished / 1000));
                Log.d("Timer", String.valueOf(millisUntilFinished / 1000));
            }

            public void onFinish() {
                timerView.setText("0");
                Log.d("timerTag", "onFinishMethodOfTimer");
                if(randy.nextInt(10) < DifficultyPicker.i){
                    computerScore++;
                }
                Intent i = new Intent(getApplicationContext(), Correct.class);
                i.putExtra("Correct", "Time's Up");
                i.putExtra("ComputerScore",computerScore);
                i.putExtra("CorrectAnswer",correctAnswer);
                onStop();
                startActivity(i);
            }
        }.start();
    }

    public void onClick(View v){
        Button button = (Button)findViewById(v.getId());
        Random randy = new Random();
        if(randy.nextInt(10) < DifficultyPicker.i){
            computerScore++;
        }

        Log.d("Button ID--->>>", String.valueOf(v.getId()));
        Log.d("Button Text--->>>", String.valueOf(button.getText()));
        if(button.getTag().equals("Correct")) {
            Intent intent = new Intent(this, Correct.class);
            intent.putExtra("Correct", "Correct");
            intent.putExtra("CorrectAnswer","");
            intent.putExtra("ComputerScore",computerScore);
            timer.cancel();
            startActivity(intent);
        }
        else{
            Intent intent = new Intent(this, Correct.class);
            intent.putExtra("Correct", "Incorrect");
            intent.putExtra("CorrectAnswer",correctAnswer);
            intent.putExtra("ComputerScore",computerScore);
            timer.cancel();
            startActivity(intent);
        }
    }

    @Override
    public void onBackPressed(){

    }

}