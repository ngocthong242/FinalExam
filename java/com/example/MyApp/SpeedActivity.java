package com.example.MyApp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import java.text.DecimalFormat;

public class SpeedActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_speed);
        Button button;
        EditText valueToBeConverted;
        EditText valueConverted;
        Spinner convertToDropdown;
        Spinner convertFromDropdown;
        final double METER_PER_SECOND = 1;
        final double KILOMETER_PER_HOUR = 3.6;
        final double KILOMETER_PER_SECOND= 0.001;
        final double KNOT= 1.94384449;
        final double MILE_PER_HOUR= 2.3693629;
        final double FOOT_PER_SECOND= 3.2808399;
        final double INCH_PER_SECOND= 39.3700787;



        valueConverted =  findViewById(R.id.value_converted);
        valueToBeConverted = findViewById(R.id.value_to_be_converted);
        convertToDropdown = findViewById(R.id.convert_to);
        convertFromDropdown =  findViewById(R.id.convert_from);
        button =  findViewById(R.id.button);

        String[] dropDownList = {"Meter per second (m/s)", "Kilometer per hound (km/h)","Kilometer per second (km/s)",
                "Knot (kn)","Mile per hour (mph)","Foot per second (fps)","Inch per second(ips)" };

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
                if (from == "Meter per second (m/s)") {fromUnit = METER_PER_SECOND ;}
                if (from == "Kilometer per hound (km/h)") {fromUnit = KILOMETER_PER_HOUR;}
                if (from == "Kilometer per second (km/s)") {fromUnit = KILOMETER_PER_SECOND ;}
                if (from == "Knot (kn)") {fromUnit = KNOT ;}
                if (from == "Mile per hour (mph)") {fromUnit = MILE_PER_HOUR;}
                if (from == "Foot per second (fps)") {fromUnit = FOOT_PER_SECOND ;}
                if (from == "Inch per second(ips)") {fromUnit = INCH_PER_SECOND ;}
                to = convertToDropdown.getSelectedItem().toString();
                if (to == "Meter per second (m/s)") {toUnit = METER_PER_SECOND ;}
                if (to == "Kilometer per hound (km/h)") {toUnit = KILOMETER_PER_HOUR;}
                if (to == "Kilometer per second (km/s)") {toUnit = KILOMETER_PER_SECOND ;}
                if (to == "Knot (kn)") {toUnit = KNOT ;}
                if (to == "Mile per hour (mph)") {toUnit = MILE_PER_HOUR;}
                if (to == "Foot per second (fps)") {toUnit = FOOT_PER_SECOND ;}
                if (to == "Inch per second(ips)") {toUnit = INCH_PER_SECOND ;}
                double value = Double.valueOf(valueToBeConverted.getText().toString());
                double result = value*(toUnit/fromUnit);
//                result= Double.parseDouble(new DecimalFormat("##.####").format(result));
                valueConverted.setText(String.valueOf(result));

            }
        });


    }
}