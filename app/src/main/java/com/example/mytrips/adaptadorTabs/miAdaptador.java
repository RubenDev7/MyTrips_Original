package com.example.mytrips.adaptadorTabs;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Lifecycle;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.example.mytrips.fragments.descubrir;
import com.example.mytrips.fragments.misViajes;
import com.example.mytrips.fragments.nuevoViaje;

public class miAdaptador extends FragmentStateAdapter {

    public miAdaptador(@NonNull FragmentActivity fragmentActivity) {
        super(fragmentActivity);
    }

    public miAdaptador(@NonNull Fragment fragment) {
        super(fragment);
    }

    public miAdaptador(@NonNull FragmentManager fragmentManager, @NonNull Lifecycle lifecycle) {
        super(fragmentManager, lifecycle);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
       switch (position) {
           case 0 : nuevoViaje nuevoviaje1 = new nuevoViaje();
           return nuevoviaje1;
           case 1 :
               misViajes misViajes1 = new misViajes();
               return misViajes1;
           case 2 :
               descubrir descubrir1 = new descubrir();
               return descubrir1;
           default : return null;
       }
    }

    public CharSequence getTabTitle (int position) {
        switch (position) {
            case 0 : return "NUEVO VIAJE";
            case 1: return "MIS VIAJES";
            case 2: return "RECOMENDACIONES";
            default : return "MyTrips";
        }
    }

    @Override
    public int getItemCount() {
        return 3;
    }



}
