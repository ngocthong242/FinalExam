package com.example.MyApp;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;


public class BMIFragment extends Fragment {
Button btnOpen3;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View  view = inflater.inflate(R.layout.fragment_bmi, container, false);
        btnOpen3= view.findViewById(R.id.btnOpen3);
        btnOpen3.setOnClickListener(new View.OnClickListener() {


            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(),FiveActivity.class);
                startActivity(intent);
            }
        });
        return view;
    }
}