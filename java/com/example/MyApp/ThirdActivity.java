package com.example.MyApp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;

import java.text.DecimalFormat;

public class ThirdActivity extends AppCompatActivity {
    Button ansBtn, againBtn;
    TextView showAns;
    EditText getVal;
    RadioButton c2f,f2c,k2p;
    Double x;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);
        ansBtn = findViewById(R.id.ansBtn);
        showAns = findViewById(R.id.showAns);
        getVal = findViewById(R.id.getVal);
        c2f = findViewById(R.id.c2f);
        f2c = findViewById(R.id.f2c);
        k2p =findViewById(R.id.k2p);
        againBtn = findViewById(R.id.againBtn);

        ansBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (getVal.getText().toString().isEmpty()){
                    showAns.setText("Please give temperature");
                }else{

                    x = Double.parseDouble(String.valueOf(getVal.getText()));
                   if (c2f.isChecked()){
                       x = (x*9)/5+32;
                        // ths is Equation
                       x = Double.parseDouble(new DecimalFormat("##.####").format(x));
                       showAns.setText(String.valueOf(x)+ " Degree F");
                   }
                   else if (f2c.isChecked()){
                       x = (x-32)*5/9;
                       x = Double.parseDouble(new DecimalFormat("##.####").format(x));
                       showAns.setText(String.valueOf(x) + " Degree C");
                   }
                 else if (k2p.isChecked()){
                       x = (x*2.20462);
                       x = Double.parseDouble(new DecimalFormat("##.####").format(x));
                       showAns.setText(String.valueOf(x) + "  Pound");
                   }
                   else{
                       showAns.setText("Please Select An Option ! ");
                   }
                }
            }
        });
    }
}