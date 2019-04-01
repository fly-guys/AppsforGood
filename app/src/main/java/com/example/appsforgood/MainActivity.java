package com.example.appsforgood;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.RotateAnimation;
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

    private ArrayList<QData> questions = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imageView=(ImageView)findViewById(R.id.Spinner);
    }

    public void readQData(){

        InputStream is = getResources().openRawResource(R.raw.questions);
        BufferedReader reader = new BufferedReader(new InputStreamReader(is));

        String line = "";
        try {
            while((line = reader.readLine()) != null){

                //Split by ","
                String[] fields = line.split(",");

                questions.add(new QData(fields[0], fields[1], fields[2], fields[3], fields[4]));

            }
        }

        catch(IOException io) {

            Log.wtf("MainActivity", "ERROR raeding data on line " + line);
        }

        String songStr = "";

        for(QData q : questions){
            songStr += q.getQuestion() + " " + q.getAns1() + " " + q.getAns2() + " " + q.getAns3() + " " + q.getAns4() + "\n";


            TextView songView = (TextView) findViewById(R.id.questionText);

            songView.setText(songStr);
        }
    }

    /**
     * public void nextButtonAction(View v)
     *     {
     *         //Get Global Controller Class object (see application tag in AndroidManifest.xml)
     *         final Controller aController = (Controller) getApplicationContext();
     *
     *         TextView textView = (TextView) findViewById(R.id.firstData);
     *         String productName = textView.getText().toString();
     *         System.out.println("PRODUCT NAME" + productName);
     *         aController.getData().setProductName(productName);
     *
     *         Intent intent = new Intent(MainActivity.this, MainActivity2Activity.class);
     *         startActivity(intent);
     *
     *     }
     */


//    public void rotateAnimation(View v) {
//        rotateAnimation = AnimationUtils.loadAnimation(this, R.anim.rotate);
//        imageView.startAnimation(rotateAnimation);
//
//    }
}
