package com.example.appsforgood;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.RotateAnimation;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    Random randy = new Random();

    Animation rotateAnimation;
    ImageView imageView;

    private ArrayList<QData> questionList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_questionview);

//        imageView=(ImageView)findViewById(R.id.Spinner);

        readQData();
    }

    public void readQData(){

        InputStream is = getResources().openRawResource(R.raw.questions);
        BufferedReader reader = new BufferedReader(new InputStreamReader(is));

        String line = "";
        try {
            while((line = reader.readLine()) != null){

                //Split by ","
                String[] fields = line.split("~");

                questionList.add(new QData(fields[0], fields[1], fields[2], fields[3], fields[4]));

            }
        }

        catch(IOException io) {

            Log.wtf("MainActivity", "ERROR reading data on line " + line);
        }

        String qStr = "";
        String ans1Str = "";
        String ans2Str = "";
        String ans3Str = "";
        String ans4Str = "";
        String correctAnswer = ans1Str;


        for(QData q : questionList){
            qStr += q.getQuestion();
            ans1Str += q.getAns1();
            ans2Str += q.getAns2();
            ans3Str += q.getAns3();
            ans4Str += q.getAns4();

            ArrayList<String> answers = new ArrayList<>();
            answers.add(ans1Str);
            answers.add(ans2Str);
            answers.add(ans3Str);
            answers.add(ans4Str);

            TextView qView = (TextView) findViewById(R.id.questionText);
            Button ans1Button = (Button) findViewById(R.id.option1);
            Button ans2Button = (Button) findViewById(R.id.option2);
            Button ans3Button = (Button) findViewById(R.id.option3);
            Button ans4Button = (Button) findViewById(R.id.option4);

            qView.setText(qStr);
            ans1Button.setText(answers.get(randy.nextInt(3)));
            answers.remove(ans1Button.getText());
            ans2Button.setText(answers.get(randy.nextInt(2)));
            answers.remove(ans2Button.getText());
            ans3Button.setText(answers.get(randy.nextInt(1)));
            answers.remove(ans3Button.getText());
            ans4Button.setText(answers.get(0));
        }
    }




//    public void rotateAnimation(View v) {
//        rotateAnimation = AnimationUtils.loadAnimation(this, R.anim.rotate);
//        imageView.startAnimation(rotateAnimation);
//
//    }
}
