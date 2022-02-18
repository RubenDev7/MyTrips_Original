package com.example.mytrips.activitiesToolBar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.mytrips.R;
import com.example.mytrips.recyclerAdapter.recycler_adapter;
import com.example.mytrips.sqlite.adminsqlite;
import com.example.mytrips.viaje;

import java.util.ArrayList;

public class favoritos extends AppCompatActivity {
    Toolbar perfilToolbar;
    RecyclerView recyclerFavs;
    ArrayList <viaje> arrayViajesFavoritos = new ArrayList<>();
    SQLiteDatabase db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_favoritos);
        main();
    }

    private void main() {
        controls();
        back();
        consultarBBDD();
        initRecycler();
    }

    private void controls() {
        perfilToolbar = findViewById(R.id.toolbarPerfil);
        setSupportActionBar(perfilToolbar);
        perfilToolbar.setNavigationIcon(getResources().getDrawable(R.drawable.ic_baseline_keyboard_backspace_24));
        recyclerFavs = findViewById(R.id.recyclerFavoritos);
    }

    private void consultarBBDD() {
        adminsqlite bbdd = new adminsqlite(getApplicationContext(),"DBViajesFAVS",null,1);
        db = bbdd.getReadableDatabase();
        Cursor fila = db.rawQuery("select * from viajes_favoritos",null);
        while (fila.moveToNext()) {
            arrayViajesFavoritos.add(new viaje(R.drawable.heart,fila.getString(0),
                    fila.getString(1),
                    fila.getString(2),
                    fila.getString(3),
                    fila.getString(4),
                    fila.getString(5)));
        }
        if(arrayViajesFavoritos.isEmpty()){
            Toast.makeText(getApplicationContext(),"No tinenes favoritos",Toast.LENGTH_SHORT).show();
        }
        db.close();
    }

    private void initRecycler() {
        recycler_adapter adapter = new recycler_adapter(arrayViajesFavoritos,getApplicationContext());
        recyclerFavs.setHasFixedSize(true);
        recyclerFavs.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        recyclerFavs.setAdapter(adapter);
        DividerItemDecoration dv = new DividerItemDecoration(getApplicationContext(),new LinearLayoutManager(getApplicationContext()).getOrientation());
        recyclerFavs.addItemDecoration(dv);
    }

    private void back() {
        perfilToolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //regresar al main
                finish();
            }
        });
    }
}