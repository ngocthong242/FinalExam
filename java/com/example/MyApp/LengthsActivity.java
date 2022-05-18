package com.example.MyApp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import java.text.DecimalFormat;

public class LengthsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lenght);
        Button button;
        EditText valueToBeConverted;
        EditText valueConverted;
        Spinner convertToDropdown;
        Spinner convertFromDropdown;
        final double meters = 1;
        final double centimeters = 100;
        final double kilometers= 0.001;
        final double inches= 39.37;
        final double miles= 0.0006214;
        final double yards= 1.093613;
        final double milimeters= 1000;



        valueConverted =  findViewById(R.id.value_converted);
        valueToBeConverted = findViewById(R.id.value_to_be_converted);
        convertToDropdown = findViewById(R.id.convert_to);
        convertFromDropdown =  findViewById(R.id.convert_from);
        button =  findViewById(R.id.button);

        String[] dropDownList = {"Millimeters (mm)", "Centimeters (cm)","Inches (Inch)","Meters (m)","Yards","Miles","Kilometers (km)" };

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, R.layout.support_simple_spinner_dropdown_item, dropDownList);
        convertToDropdown.setAdapter(adapter);
        convertFromDropdown.setAdapter(adapter);
        button.setOnClickListener(new View.OnClickListener() {


            @Override
            public void onClick(View v) {
                String from,to;
                double fromUnit = 1;
                double toUnit= 1;

                from = convertFromDropdown.getSelectedItem().toString();
                if (from == "Millimeters (mm)") {fromUnit = milimeters ;}
                if (from == "Centimeters (cm)") {fromUnit = centimeters;}
                if (from == "Inches (Inch)") {fromUnit = inches ;}
                if (from == "Meters (m)") {fromUnit = meters ;}
                if (from == "Yards") {fromUnit = yards;}
                if (from == "Miles") {fromUnit = miles ;}
                if (from == "Kilometers (km)") {fromUnit = kilometers;}
                to = convertToDropdown.getSelectedItem().toString();
                if (to == "Millimeters (mm)") {toUnit = milimeters ;}
                if (to == "Centimeters (cm)") {toUnit = centimeters;}
                if (to == "Inches (Inch)") {toUnit = inches ;}
                if (to == "Meters (m)") {toUnit = meters ;}
                if (to == "Yards") {toUnit = yards;}
                if (to == "Miles") {toUnit = miles ;}
                if (to == "Kilometers (km)") {toUnit = kilometers;}
                double tobe_convert = Double.valueOf(valueToBeConverted.getText().toString());
                double result = tobe_convert*(toUnit/fromUnit);

                valueConverted.setText(String.valueOf(result));

            }
        });


    }
}