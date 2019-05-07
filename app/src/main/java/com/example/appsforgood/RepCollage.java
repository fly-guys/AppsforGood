package com.example.appsforgood;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class RepCollage extends AppCompatActivity {
    static int i = 0;
    private Controller controller;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rep_collage);

        controller = (Controller) getApplicationContext();

        controller.createReps();

        RepObject rep = controller.getReps();

        String image;
        image = rep.getImage();

        ImageView repPicture = (ImageView) findViewById(R.id.repPic);

        Context context = repPicture.getContext();
        int id = context.getResources().getIdentifier(image, "drawable", context.getPackageName());
        repPicture.setImageResource(id);
        Log.d("RepPic------------------------->>>>>","Set Picture");

        TextView name = (TextView) findViewById(R.id.repName);
        name.setText(rep.getrepName());
        Log.d("RepName------------------------->>>>>","Set Name");

        TextView position = (TextView) findViewById(R.id.repPosition);
        position.setText(rep.getposition());
        Log.d("RepPos------------------------->>>>>","Set Pos");

        TextView party = (TextView) findViewById(R.id.repParty);
        party.setText("Party: " + rep.getparty());
        Log.d("RepParty------------------------->>>>>","Set Party");

        TextView years = (TextView) findViewById(R.id.repYears);
        years.setText("Years in Office: " + rep.getyearsInOffice() + " years");
        Log.d("RepYears------------------------->>>>>","Set Years");

        TextView description = (TextView) findViewById(R.id.repDescription);
        description.setText(rep.getDescription());
        Log.d("RepDes------------------------->>>>>","Set Descrip");

    }

    public void backButton(View v) {
        Intent intent = new Intent(this, LearnActivity.class);
        startActivity(intent);
    }


    public void nextRep(View v){
        Intent intent = new Intent(this,RepCollage.class);
        startActivity(intent);
    }

}
