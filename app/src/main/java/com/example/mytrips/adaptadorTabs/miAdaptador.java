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
           case 0 : return new nuevoViaje();
           case 1 : return new misViajes();
           case 2 : return new descubrir();
           default : return null;
       }
    }

    public CharSequence getTabTitle (int position) {
        switch (position) {
            case 0 : return "NUEVO VIAJE";
            case 1: return "MIS VIAJES";
            case 2: return "DESCUBRIR";
            default : return "MyTrips";
        }
    }

    @Override
    public int getItemCount() {
        return 3;
    }



}
