package com.example.mytrips;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.viewpager2.widget.ViewPager2;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;


import com.example.mytrips.activitiesToolBar.ajustes;
import com.example.mytrips.activitiesToolBar.favoritos;
import com.example.mytrips.adaptadorTabs.miAdaptador;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

public class MainActivity extends AppCompatActivity {
    public Toolbar myTB;
    public TabLayout myTL;
    public ViewPager2 myVP2;
    public miAdaptador adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        main();
    }

    private void main() {
        controls();
        initTabs();
    }
    private void controls() {
        myTB = findViewById(R.id.myToolbar);
        setSupportActionBar(myTB);
        myTL = findViewById(R.id.myTabs);
        myVP2 = findViewById(R.id.myViewPager2);
        //Con esto se cambia el icono predeterminado de la ToolBar
        myTB.setOverflowIcon(getDrawable(R.drawable.ic_baseline_more_vert_24));
    }

    private void initTabs() {
        adapter = new miAdaptador(this);
        myVP2.setAdapter(adapter);
        new TabLayoutMediator(myTL,myVP2,(tab,position)->tab.setText(adapter.getTabTitle(position))).attach();
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.toolbar_menu,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.favoritos) {
            Intent i = new Intent(this, favoritos.class);
            startActivity(i);
        }
        if (id == R.id.ajustes) {
            Intent i = new Intent(this, ajustes.class);
            startActivity(i);        }
        if (id == R.id.cerrarSesion) {
            Toast.makeText(getApplicationContext(),"PRUEBA CIERRE SESION TOOLBAR", Toast.LENGTH_LONG).show();
        }
        return super.onOptionsItemSelected(item);
    }
}
