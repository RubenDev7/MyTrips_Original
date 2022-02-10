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


import com.example.mytrips.activitiesToolBar.perfil;
import com.example.mytrips.adaptadorTabs.miAdaptador;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

public class MainActivity extends AppCompatActivity {
    public Toolbar myTB;
    public TabLayout myTL;
    public ViewPager2 myVP2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        main();
    }

    private void main() {
        controls();
        initApp();
    }

    private void initApp() {
        miAdaptador adapter = new miAdaptador(this);
        myVP2.setAdapter(adapter);
        new TabLayoutMediator(myTL,myVP2,(tab,position)->tab.setText(adapter.getTabTitle(position))).attach();
    }

    private void controls() {
    myTB = findViewById(R.id.myToolbar);
    setSupportActionBar(myTB);
    myTL = findViewById(R.id.myTabs);
    myVP2 = findViewById(R.id.myViewPager2);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.toolbar_menu,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.perfil) {
            Intent i = new Intent(this, perfil.class);
            startActivity(i);

        }
        if (id == R.id.ajustes) {
            Toast.makeText(getApplicationContext(),"PRUEBA AJUSTES TOOLBAR", Toast.LENGTH_LONG).show();
        }
        if (id == R.id.cerrarSesion) {
            Toast.makeText(getApplicationContext(),"PRUEBA CIERRE SESION TOOLBAR", Toast.LENGTH_LONG).show();
        }
        return super.onOptionsItemSelected(item);
    }
}
