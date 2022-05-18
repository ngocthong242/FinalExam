package com.example.MyApp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import java.text.DecimalFormat;

public class TemperatureActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_temperature);
        Button button;
        EditText valueToBeConverted;
        EditText valueConverted;
        Spinner convertToDropdown;
        Spinner convertFromDropdown;




        valueConverted =  findViewById(R.id.value_converted);
        valueToBeConverted = findViewById(R.id.value_to_be_converted);
        convertToDropdown = findViewById(R.id.convert_to);
        convertFromDropdown =  findViewById(R.id.convert_from);
        button =  findViewById(R.id.button);

        String[] dropDownList = {"C", "F","K"};

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, R.layout.support_simple_spinner_dropdown_item, dropDownList);
        convertToDropdown.setAdapter(adapter);
        convertFromDropdown.setAdapter(adapter);
        button.setOnClickListener(new View.OnClickListener() {


            @Override
            public void onClick(View v) {
                String from,to;
                double fromUnit = 1;
                double toUnit= 1;
                double result= 1;
                from = convertFromDropdown.getSelectedItem().toString();
                to = convertToDropdown.getSelectedItem().toString();
                double value = Double.valueOf(valueToBeConverted.getText().toString());
                if (from == "C" && to == "F") { result = (9/5)*value + 32;}
                if (from == "F" && to == "C") { result = (5/9)*value - 32;}
                if (from == "C" && to == "K") { result = value + 273.15;}
                if (from == "K" && to == "C") { result = value - 273.15;}
                if (from == "K" && to == "F") { result = (9/5)*(value - 273.15) + 32;}
                if (from == "F" && to == "K") { result = (5/9)*(value - 32) + 273.15;}
                if (from == "K" && to == "K"||from == "F" && to == "F"||from == "C" && to == "C")
                { result = value;}
                result = Double.parseDouble(new DecimalFormat("##.####").format(result));
                valueConverted.setText(String.valueOf(result));


            }
        });


    }
}