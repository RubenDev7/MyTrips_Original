package com.example.mytrips.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.mytrips.R;

public class descubrir extends Fragment {
    TextView tv;

    public descubrir() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View vista = inflater.inflate(R.layout.fragment_descubrir, container, false);
        // Inflate the layout for this fragment
        tv = vista.findViewById(R.id.tvCommingSoon);
        tv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getContext(),"Página pendiente de desarrollo", Toast.LENGTH_SHORT).show();
            }
        });
        return vista;
    }
}