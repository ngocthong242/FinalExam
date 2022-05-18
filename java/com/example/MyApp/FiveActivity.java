package com.example.MyApp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

public class FiveActivity extends AppCompatActivity {
    android.widget.Button mcalculateBMI;

    TextView mcurrent_height, mcurrent_age, mcurrent_weight;
    ImageView mincrementage, mincrementweight, mdecrementage, mdecrementweight;
    SeekBar mseekbar_for_height;

    RelativeLayout mmale, mfemale;

    int intweight = 55 ;
    int intage = 22;
    int currentprogress;
    String mintprogress = "170" ;
    String typeofuser="0";
    String weight2="55";
    String age2="22";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_five);

        mcalculateBMI=findViewById(R.id.calculateBMI);
        mcurrent_age=findViewById(R.id.current_age);
        mcurrent_weight=findViewById(R.id.current_weight);
        mcurrent_height=findViewById(R.id.current_height);
        mincrementage=findViewById(R.id.incremenage);
        mincrementweight=findViewById(R.id.incrementweight);
        mdecrementage=findViewById(R.id.decrementage);
        mdecrementweight=findViewById(R.id.decrementweight);
        mseekbar_for_height=findViewById(R.id.seekbar_for_height);
        mmale=findViewById(R.id.male);
        mfemale=findViewById(R.id.female);


        //event for male female icon when click
        mmale.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mmale.setBackground(ContextCompat.getDrawable(getApplicationContext(),R.drawable.malefemalefocus));
                mfemale.setBackground(ContextCompat.getDrawable(getApplicationContext(), R.drawable.malefemalenotfocus));
                typeofuser="Male";
            }
        });

        mfemale.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mfemale.setBackground(ContextCompat.getDrawable(getApplicationContext(),R.drawable.malefemalefocus));
                mmale.setBackground(ContextCompat.getDrawable(getApplicationContext(), R.drawable.malefemalenotfocus));
                typeofuser="Female";
            }
        });
        //seek bar
        mseekbar_for_height.setMax(300);
        mseekbar_for_height.setProgress(170);
        mseekbar_for_height.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                currentprogress=progress;
                mintprogress=String.valueOf(currentprogress);
                mcurrent_height.setText(mintprogress);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        // event for click increment or decrement button
        mincrementage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intage=intage+1;
                age2=String.valueOf(intage);
                mcurrent_age.setText(age2);
            }
        });
        mdecrementage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intage=intage-1;
                age2=String.valueOf(intage);
                mcurrent_age.setText(age2);
            }
        });
        mincrementweight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intweight=intweight+1;
                weight2=String.valueOf(intweight);
                mcurrent_weight.setText(weight2);
            }
        });

        mdecrementweight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intweight=intweight-1;
                weight2=String.valueOf(intweight);
                mcurrent_weight.setText(weight2);
            }
        });








        mcalculateBMI.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //set condition

                if (typeofuser.equals("0")){
                    Toast.makeText(getApplicationContext(),"Choose your gender first", Toast.LENGTH_SHORT).show();
                }
                else if (mintprogress.equals("0")){
                    Toast.makeText(getApplicationContext(),"Choose your height first", Toast.LENGTH_SHORT).show();
                }
                else if (intage == 0 || intage<0){
                    Toast.makeText(getApplicationContext(),"Age does not exist", Toast.LENGTH_SHORT).show();
                }
                else if (intweight==0|| intweight<0){
                    Toast.makeText(getApplicationContext(),"Weight does not exist", Toast.LENGTH_SHORT).show();
                }
                else {
                    Intent intent = new Intent(FiveActivity.this, BMIActivity.class);
                    //pass data from Ui to calculate
                    intent.putExtra("gender", typeofuser);
                    intent.putExtra("height", mintprogress);
                    intent.putExtra("weight",weight2);
                    intent.putExtra("age",age2);
                    startActivity(intent);
                }


            }
        });


    }
}