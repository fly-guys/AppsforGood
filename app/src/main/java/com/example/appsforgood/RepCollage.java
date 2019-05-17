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
    //Data
    static int i = 0;
    private Controller controller;

    /**
     * Starts the RepCollage Activity and sets the name, picture, and description of the RepObject diplayed on the screen
     * @param savedInstanceState the Instance State
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rep_collage);

        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();
        String next = bundle.getString("Next");

        controller = (Controller) getApplicationContext();

        controller.createReps();

        RepObject rep = controller.getReps(next);

        String image;
        image = rep.getImage();

        ImageView repPicture = (ImageView) findViewById(R.id.repPic);

        Context context = repPicture.getContext();
        int id = context.getResources().getIdentifier(image, "drawable", context.getPackageName());
        repPicture.setImageResource(id);
        Log.d("RepPic->>>>>","Set Picture");

        TextView name = (TextView) findViewById(R.id.repName);
        name.setText(rep.getRepName());
        Log.d("RepName---->>>>>","Set Name");

        TextView position = (TextView) findViewById(R.id.repPosition);
        position.setText(rep.getPosition());
        Log.d("RepPos--->>>>>","Set Pos");

        TextView party = (TextView) findViewById(R.id.repParty);
        party.setText("Party: " + rep.getParty());
        Log.d("RepParty---->>>>>","Set Party");

        TextView years = (TextView) findViewById(R.id.repYears);
        years.setText("Years in Office: " + rep.getYearsInOffice() + " years");
        Log.d("RepYears-->>>>>","Set Years");

        TextView description = (TextView) findViewById(R.id.repDescription);
        description.setText(rep.getDescription());
        Log.d("RepDes----->>>>>","Set Descrip");

    }

    /**
     * Starts the Learn Activity
     * @param v the View
     */
    public void backButton(View v) {
        Intent intent = new Intent(this, LearnActivity.class);
        startActivity(intent);
    }

    /**
     * Starts the RepCollage Activity again to display the next RepObject
     * @param v the View
     */
    public void nextRep(View v){
        Intent intent = new Intent(this,RepCollage.class);
        intent.putExtra("Next","Next");
        startActivity(intent);
    }

    /**
     *  Starts the RepCollage Activity again to display the previous RepObject
     * @param v the View
     */
    public void prevRep(View v){
        Intent intent = new Intent(this,RepCollage.class);
        intent.putExtra("Next","Previous");
        startActivity(intent);

    }

    /**
     * Disables the back button on the Android device
     */
    @Override
    public void onBackPressed(){

    }

}
