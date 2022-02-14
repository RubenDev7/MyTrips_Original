package com.example.mytrips.fragments;

import android.content.Context;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;

import com.example.mytrips.R;
import com.example.mytrips.recyclerAdapter.miAdaptador;
import com.example.mytrips.viaje;

import java.util.ArrayList;
import java.util.List;

public class misViajes extends Fragment {
    ArrayList<viaje> arrayViajes;
    Context context;

    public misViajes() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View vista = inflater.inflate(R.layout.fragment_mis_viajes, container, false);
        main();
        miAdaptador adapter = new miAdaptador(arrayViajes,context);
        RecyclerView recycler = vista.findViewById(R.id.recyclerMisViajes);
        recycler.setHasFixedSize(true);
        recycler.setLayoutManager(new LinearLayoutManager(context));
        recycler.setAdapter(adapter);

        DividerItemDecoration dv = new DividerItemDecoration(context,new LinearLayoutManager(context).getOrientation());
        recycler.addItemDecoration(dv);
        // Inflate the layout for this fragment
        return vista;
    }

    private void main() {
    context = getActivity().getApplicationContext();

    arrayViajes = new ArrayList<>();
    arrayViajes.add(new viaje("ESPAÑA","MÁLAGA","TREN","15/04/2022","25/04/2022","HOTEL"));
    arrayViajes.add(new viaje("ESPAÑA","MÁLAGA","TREN","15/04/2022","25/04/2022","HOTEL"));
    arrayViajes.add(new viaje("ESPAÑA","MÁLAGA","TREN","15/04/2022","25/04/2022","HOTEL"));
    arrayViajes.add(new viaje("ESPAÑA","MÁLAGA","TREN","15/04/2022","25/04/2022","HOTEL"));
    arrayViajes.add(new viaje("ESPAÑA","MÁLAGA","TREN","15/04/2022","25/04/2022","HOTEL"));
    arrayViajes.add(new viaje("ESPAÑA","MÁLAGA","TREN","15/04/2022","25/04/2022","HOTEL"));
    arrayViajes.add(new viaje("ESPAÑA","MÁLAGA","TREN","15/04/2022","25/04/2022","HOTEL"));
    }
}