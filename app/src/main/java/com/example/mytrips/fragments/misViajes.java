package com.example.mytrips.fragments;

import android.content.Context;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.mytrips.R;
import com.example.mytrips.recyclerAdapter.recycler_adapter;
import com.example.mytrips.viaje;

import java.util.ArrayList;

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
        recycler_adapter adapter = new recycler_adapter(arrayViajes,context);
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
    arrayViajes.add(new viaje(R.drawable.tenerife_spain,"ESPAÑA","STA CRUZ DE TENERIFE","AVION","15/04/2022","25/04/2022","CAMPING"));
    arrayViajes.add(new viaje(R.drawable.santorini_grecia,"GRECIA","SANTORINI","AVION","15/04/2022","25/04/2022","HOTEL"));
    arrayViajes.add(new viaje(R.drawable.berlin,"ALEMANIA","BERLIN","TREN","15/04/2022","25/04/2022","APARTAMENTO"));
    arrayViajes.add(new viaje(R.drawable.cancun,"MEXICO","CANCUN","AVION","15/04/2022","25/04/2022","HOTEL"));
    arrayViajes.add(new viaje(R.drawable.estambul,"TURQUIA","ESTAMBUL","AVION","15/04/2022","25/04/2022","HABITACION"));
    arrayViajes.add(new viaje(R.drawable.tokyo,"JAPON","TOKYO","AVION","15/04/2022","25/04/2022","HOTEL"));
    arrayViajes.add(new viaje(R.drawable.londres,"REINO UNIDO","LONDRES","BARCO","15/04/2022","25/04/2022","APARTAMENTO"));
    arrayViajes.add(new viaje(R.drawable.paris,"FRANCIA","PARIS","AUTOBUS","15/04/2022","25/04/2022","APARTAMENTO"));

    }
}