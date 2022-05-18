package com.example.MyApp;

import android.content.Intent;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;


public class LenghtFragment extends Fragment {
    Button btnLength;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_lenght, container, false);

        btnLength = view.findViewById(R.id.btnLenght);
        btnLength.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getContext(),LengthsActivity.class);
                startActivity(intent);
            }

        });

        return view;

    }
}
